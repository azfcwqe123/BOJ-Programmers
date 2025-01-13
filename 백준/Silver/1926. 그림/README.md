# [Silver I] 그림 - 1926 

[문제 링크](https://www.acmicpc.net/problem/1926) 

### 성능 요약

메모리: 45540 KB, 시간: 396 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 13일 20:27:07

### 문제 설명

<p>어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.</p>

### 입력 

 <p>첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)</p>

### 출력 

 <p>첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.</p>

---

BFS 풀이, 396ms

```java
import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static int n, m, cnt=0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1) {
                    ans = Math.max(ans, BFS(i, j));
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
        System.out.println(ans);
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        map[x][y] = 0;
        
        int area = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Point cur = Q.poll();
                area++;
                
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        Q.offer(new Point(nx, ny));
                    }
                }    
            }
        }
        
        return area;
        
    }
    
    private static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}


```

---

DFS 풀이, 624ms

```java
import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static int n, m, cnt=0, area;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1) {
                    area = 1; // 넓이의 시작은 1
                    DFS(i, j);
                    ans = Math.max(ans, area);
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
        System.out.println(ans);
    }
    
    public static void DFS(int x, int y) {
        
        map[x][y] = 0;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                area++;
                DFS(nx, ny);
            }
        }
    }
    
    private static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}


```

---

처음에 틀렸던 이유:

```java
Queue<Point> Q = new LinkedList<>();
Q.offer(new Point(x, y));
map[x][y] = 0; // 시작 부분을 0으로 만들어주는걸 깜빡해버림
```

---

![image](https://github.com/user-attachments/assets/1dc1751e-52a5-4ab9-8f80-5b248e34542e)
