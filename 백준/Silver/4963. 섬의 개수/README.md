# [Silver II] 섬의 개수 - 4963 

[문제 링크](https://www.acmicpc.net/problem/4963) 

### 성능 요약

메모리: 16344 KB, 시간: 156 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 12월 30일 18:36:59

### 문제 설명

<p>정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/island.png" style="width: 283px; height: 141px;"></p>

<p>한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. </p>

<p>두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.</p>

### 입력 

 <p>입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.</p>

<p>둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.</p>

<p>입력의 마지막 줄에는 0이 두 개 주어진다.</p>

### 출력 

 <p>각 테스트 케이스에 대해서, 섬의 개수를 출력한다.</p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[][] board;
    public static boolean[][] visited;
    public static int h, w;
    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if(w == 0 && h == 0) break;
            
            board = new int[h][w];
            visited = new boolean[h][w];
            int ans = 0;
            
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        BFS(i, j);
                        ans++;
                    }
                }
            }
            
            sb.append(ans + "\n");
            
        }
        
        System.out.print(sb);
        
    }
    
    public static void BFS(int x, int y) {
        Queue<Node> Q = new LinkedList<>();
        visited[x][y] = true;
        
        Q.offer(new Node(x, y));
        
        while(!Q.isEmpty()) {
            Node cur = Q.poll();
            
            for(int i=0; i<8; i++) {
                int nx = dirX[i] + cur.x;
                int ny = dirY[i] + cur.y;
                
                if(range_check(nx, ny) && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    Q.offer(new Node(nx, ny));
                }
            }
        }
    }
    
    public static boolean range_check(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < h && ny < w);
    }
}




```

---

DFS

```java
import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[][] board;
    public static boolean[][] visited;
    public static int h, w;
    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if(w == 0 && h == 0) break;
            
            board = new int[h][w];
            visited = new boolean[h][w];
            int ans = 0;
            
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        DFS(i, j);
                        ans++;
                    }
                }
            }
            
            sb.append(ans + "\n");
            
        }
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int x, int y) {
        
        visited[x][y] = true;
        
        for(int i=0; i<8; i++) {
            int nx = dirX[i] + x;
            int ny = dirY[i] + y;
            
            if(range_check(nx, ny) && !visited[nx][ny] && board[nx][ny] == 1) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
        
    }
    
    public static boolean range_check(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < h && ny < w);
    }
}




```

---

![image](https://github.com/user-attachments/assets/3aec4fd0-4d6e-46bc-a1b3-62a182f034c8)
