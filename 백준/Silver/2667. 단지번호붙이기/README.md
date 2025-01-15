# [Silver I] 단지번호붙이기 - 2667 

[문제 링크](https://www.acmicpc.net/problem/2667) 

### 성능 요약

메모리: 14152 KB, 시간: 104 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 15일 18:10:11

### 문제 설명

<p><그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/ITVH9w1Gf6eCRdThfkegBUSOKd.png" style="height:192px; width:409px"></p>

### 입력 

 <p>첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.</p>

### 출력 

 <p>첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.</p>

---

DFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int[][] map;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n, tmp;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    tmp = 1;
                    DFS(i, j);
                    list.add(tmp);
                    ans++;
                }
            }
        }
        
        Collections.sort(list);
        sb.append(ans).append("\n");
        
        for(int x : list) sb.append(x).append("\n");
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int x, int y) {
        
        map[x][y] = 0;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                tmp++;
                DFS(nx, ny);
            }
        }
        
    }
    
    private static boolean rangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
}


```

---

BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int[][] map;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    list.add(BFS(i, j));
                    ans++;
                }
            }
        }
        
        Collections.sort(list);
        sb.append(ans).append("\n");
        
        for(int x : list) sb.append(x).append("\n");
        
        System.out.print(sb);
        
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        map[x][y] = 0;
        
        int area = 1;
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    area++;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
        
        return area;
        
    }
    
    private static boolean rangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/a5be0107-a4bf-4528-b799-22289e18f928)
