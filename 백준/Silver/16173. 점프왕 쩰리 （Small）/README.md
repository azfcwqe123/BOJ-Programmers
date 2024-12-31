# [Silver IV] 점프왕 쩰리 (Small) - 16173 

[문제 링크](https://www.acmicpc.net/problem/16173) 

### 성능 요약

메모리: 14096 KB, 시간: 104 ms

### 분류

너비 우선 탐색, 브루트포스 알고리즘, 깊이 우선 탐색, 그래프 이론, 그래프 탐색, 구현

### 제출 일자

2024년 12월 31일 10:36:00

### 문제 설명

<p>‘쩰리’는 점프하는 것을 좋아하는 젤리다. 단순히 점프하는 것에 지루함을 느낀 ‘쩰리’는 새로운 점프 게임을 해보고 싶어 한다. 새로운 점프 게임의 조건은 다음과 같다.</p>

<ol>
	<li>‘쩰리’는 가로와 세로의 칸 수가 같은 정사각형의 구역 내부에서만 움직일 수 있다. ‘쩰리’가 정사각형 구역의 외부로 나가는 경우엔 바닥으로 떨어져 즉시 게임에서 패배하게 된다.</li>
	<li>‘쩰리’의 출발점은 항상 정사각형의 가장 왼쪽, 가장 위의 칸이다. 다른 출발점에서는 출발하지 않는다.</li>
	<li>‘쩰리’가 이동 가능한 방향은 오른쪽과 아래 뿐이다. 위쪽과 왼쪽으로는 이동할 수 없다.</li>
	<li>‘쩰리’가 가장 오른쪽, 가장 아래 칸에 도달하는 순간, 그 즉시 ‘쩰리’의 승리로 게임은 종료된다.</li>
	<li>‘쩰리’가 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼이다. 칸에 쓰여 있는 수 초과나 그 미만으로 이동할 수 없다.</li>
</ol>

<p>새로운 게임이 맘에 든 ‘쩰리’는, 계속 게임을 진행해 마침내 최종 단계에 도달했다. 하지만, 게임을 진행하는 구역이 너무 넓어져버린 나머지, 이 게임에서 이길 수 있는지 없는지 가늠할 수 없어졌다. ‘쩰리’는 유능한 프로그래머인 당신에게 주어진 구역에서 승리할 수 있는 지 알아봐 달라고 부탁했다. ‘쩰리’를 도와 주어진 게임 구역에서 끝 점(오른쪽 맨 아래 칸)까지 도달할 수 있는지를 알아보자!</p>

### 입력 

 <p>입력의 첫 번째 줄에는 게임 구역의 크기 N (2 ≤ N ≤ 3)이 주어진다.</p>

<p>입력의 두 번째 줄부터 마지막 줄까지 게임판의 구역(맵)이 주어진다.</p>

<p>게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.</p>

### 출력 

 <p>‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”(인용부호 없이), 도달할 수 없으면 “Hing” (인용부호 없이)을 한 줄에 출력합니다.</p>

---

BFS 풀이

```java
import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int[][] map; 
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        System.out.print(BFS(0, 0));
        
    }
    
    public static String BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            Point cur = Q.poll();
            
            if(cur.x == n-1 && cur.y == n-1) return "HaruHaru";
            
            int move = map[cur.x][cur.y];
            
            for(int i=0; i<len; i++) {
                
                if(cur.x < n && cur.y + move < n && !visited[cur.x][cur.y + move]) {
                    visited[cur.x][cur.y + move] = true;
                    Q.offer(new Point(cur.x, cur.y + move));
                }
                
                if(cur.x + move < n && cur.y < n && !visited[cur.x+move][cur.y]) {
                    visited[cur.x + move][cur.y] = true;
                    Q.offer(new Point(cur.x + move, cur.y));
                }
                
            }
            
        }
        
        return "Hing";
        
    }
    
}


```

---

BFS 풀이(리팩토링)

```java
import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int n;
    public static int[][] map; 
    public static boolean[][] visited;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        System.out.print(BFS(0, 0));
        
    }
    
    public static String BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            if(map[cur.x][cur.y] == -1) return "HaruHaru";
            
            for(int i=0; i<2; i++) {
                int nx = cur.x + dx[i] * map[cur.x][cur.y];
                int ny = cur.y + dy[i] * map[cur.x][cur.y];
                
                if(nx < n && ny < n && !visited[nx][ny]) {
                    Q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            
        }
        
        return "Hing";
        
    }
    
}


```

---

DFS 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int n;
    public static int[][] map; 
    public static boolean[][] visited;
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        DFS(0, 0);
        System.out.print("Hing");
    }
    
    public static void DFS(int x, int y) {
        
        if(map[x][y] == -1) {
            System.out.print("HaruHaru");
            System.exit(0);
        }
        
        for(int i=0; i<2; i++) {
            int nx = x + dx[i] * map[x][y];
            int ny = y + dy[i] * map[x][y];
            
            if(nx < n && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/3ee66e72-7e6a-4612-a9fd-dbed0c7c25d5)
