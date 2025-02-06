# [Gold IV] 연구소 - 14502 

[문제 링크](https://www.acmicpc.net/problem/14502) 

### 성능 요약

메모리: 299212 KB, 시간: 940 ms

### 분류

너비 우선 탐색, 브루트포스 알고리즘, 그래프 이론, 그래프 탐색, 구현

### 제출 일자

2025년 2월 7일 00:07:22

### 문제 설명

<p>인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.</p>

<p>연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. </p>

<p>일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.</p>

<p>예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.</p>

<pre>2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0</pre>

<p>이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.</p>

<p>2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.</p>

<pre>2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0</pre>

<p>바이러스가 퍼진 뒤의 모습은 아래와 같아진다.</p>

<pre>2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0</pre>

<p>벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.</p>

<p>연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)</p>

<p>둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.</p>

<p>빈 칸의 개수는 3개 이상이다.</p>

### 출력 

 <p>첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.</p>


---

백트래킹 완전 탐색 + BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[][] board;
    static boolean[][] visited;
    static int n, m, ans = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static class Virus {
        int x;
        int y;
        
        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        DFS(0);
        
        System.out.print(ans);
    }
    
    // 백트래킹, 완전탐색
    static void DFS(int depth) {
        
        if(depth == 3) {
            ans = Math.max(ans, BFS());
            return;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    DFS(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static int BFS() {
        Queue<Virus> Q = new LinkedList<>();
        
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 2) Q.offer(new Virus(i, j)); // 바이러스 추가
                if(board[i][j] != 0) visited[i][j] = true; // 벽이든, 바이러스든 true 방문 체크(나중에 false로 체크하는 것들이 전염 안된부분)
            }
        }
        
        while(!Q.isEmpty()) {
            Virus cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny]) { // 방문하지 않았고, 0인곳은 전염시킴
                    visited[nx][ny] = true;
                    Q.offer(new Virus(nx, ny));
                } 
            }
        }
         
        int cnt = 0; // false로 된곳은 바이러스 전염 안된곳
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) cnt++;
            }
        }
        
        return cnt;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}


```
완전 탐색을 해야하는 문제라서 어떻게 완전탐색을 할까 생각을 하다가, 배열로 2차원 배열을 브루트포스 알고리즘으로 완전탐색 하기엔 아닌것같아서 블로그를 찾아봤다.

https://stdio-han.tistory.com/280 백트래킹으로 완전 탐색하는건 여기서 참고했고, 나머지는 내가 코드를 짜며 완성하였다

---
![image](https://github.com/user-attachments/assets/0a5c08a8-bf03-434b-a233-ca3997cce1a3)

