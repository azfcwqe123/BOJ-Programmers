# [Silver I] 쉬운 최단거리 - 14940 

[문제 링크](https://www.acmicpc.net/problem/14940) 

### 성능 요약

메모리: 63880 KB, 시간: 684 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 20일 00:04:34

### 문제 설명

<p>지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.</p>

<p>문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.</p>

### 입력 

 <p>지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)</p>

<p>다음 n개의 줄에 m개의 숫자가 주어진다. 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.</p>

### 출력 

 <p>각 지점에서 목표지점까지의 거리를 출력한다. 원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.</p>

---

BFS
```java
import java.util.*;
import java.math.BigInteger;
import java.io.*;

class Main {
    
    static class Point {
        
        int x;
        int y;
        int cnt = 0;
        
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[][] map, ans;
    static boolean[][] visited;
    static Queue<Point> Q = new LinkedList<>();
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        ans = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    Q.offer(new Point(i, j, 0)); // 목표지점
                    visited[i][j] = true;
                }
            }
        }
        
        BFS();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 방문하지 않았는데 지나갈 수 있는 길이었다면 -1 표시
                if(!visited[i][j] && map[i][j] != 0) sb.append(-1 + " ");
                else sb.append(ans[i][j] + " ");
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void BFS() {
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    Q.offer(new Point(nx, ny, cur.cnt + 1));
                    visited[nx][ny] = true;
                    ans[nx][ny] = cur.cnt + 1;
                }
            }
        }
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/3f948222-0c8e-43bd-acec-6cdfff3125b9)
