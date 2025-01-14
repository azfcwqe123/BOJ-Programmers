# [Gold V] 적록색약 - 10026 

[문제 링크](https://www.acmicpc.net/problem/10026) 

### 성능 요약

메모리: 16240 KB, 시간: 128 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 14일 13:28:14

### 문제 설명

<p>적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.</p>

<p>크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)</p>

<p>예를 들어, 그림이 아래와 같은 경우에</p>

<pre>RRRBB
GGBBB
BBBRR
BBRRR
RRRRR</pre>

<p>적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)</p>

<p>그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)</p>

<p>둘째 줄부터 N개 줄에는 그림이 주어진다.</p>

### 출력 

 <p>적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.</p>

---

DFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int n;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        int ans1 = notCbn(); // 적록색약이 아닌 사람
        
        visited = new boolean[n][n]; // 방문 초기화
        int ans2 = Cbn(); // 적록색약인 사람
        
        System.out.print(ans1 + " " + ans2);
    }
    
    public static int notCbn() {
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    DFS(board[i][j], i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    
    public static int Cbn() {
        int cnt = 0;
        
        // 적록색약인 사람은 G와 R을 구분 못하기에 똑같은 색으로 교체해준다.
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'G') board[i][j] = 'R';
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    DFS(board[i][j], i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    
    public static void DFS(char color, int x, int y) {
        
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(rangeCheck(nx, ny) && !visited[nx][ny] && board[nx][ny] == color) {
                visited[nx][ny] = true;
                DFS(color, nx, ny);
            }
        }
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}


```

---

BFS

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
    
    public static int n;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        int ans1 = notCbn(); 
        
        visited = new boolean[n][n];
        int ans2 = Cbn();
        
        System.out.print(ans1 + " " + ans2);
    }
    
    public static int notCbn() {
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    BFS(board[i][j], i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    
    public static int Cbn() {
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'G') board[i][j] = 'R';
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    BFS(board[i][j], i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    
    public static void BFS(char color, int x, int y) {
        
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(rangeCheck(nx, ny) && !visited[nx][ny] && board[nx][ny] == color) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
        
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}


```

---

![image](https://github.com/user-attachments/assets/4aade501-75f2-4975-91af-c0d82a6a992b)
