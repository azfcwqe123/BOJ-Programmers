# [Gold III] 벽 부수고 이동하기 2 - 14442 

[문제 링크](https://www.acmicpc.net/problem/14442) 

### 성능 요약

메모리: 375712 KB, 시간: 1592 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 13일 15:12:57

### 문제 설명

<p>N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.</p>

<p>만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.</p>

<p>한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.</p>

<p>맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.</p>

### 출력 

 <p>첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.</p>

---

BFS, 최단 경로

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        
        int x;
        int y;
        int time;
        int destoryed;
        
        Point(int x, int y, int time, int destoryed) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destoryed = destoryed;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0 , 1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m][k+1]; // k+1 주목하자. k=1 이면 벽을 0번, 1번 부순 케이스로 나눌 수 있다.
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        System.out.print(BFS());
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                // 벽이 있을때
                if(map[nx][ny] == 1 && cur.destoryed < k && !visited[nx][ny][cur.destoryed + 1]) { // 벽 부순곳을 다시 지나가지 않는다. (최단경로 성질)
                    pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed + 1));
                    visited[nx][ny][cur.destoryed + 1] = true;
                }
                
                // 벽이 없을때
                else if(map[nx][ny] == 0 && !visited[nx][ny][cur.destoryed]) {
                    pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed));
                    visited[nx][ny][cur.destoryed] = true;
                }
            }
        }
        
        return -1;
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 & nx<n && ny<m;
    }
    
}


```

---
시간초과 난 이유

```java
if(map[nx][ny] == 1 && cur.destoryed < k && !visited[nx][ny][cur.destoryed]) // 오답 코드
// 이렇게하면 벽 부순적 있는곳을 다시 탐색하게 된다.
```
![image](https://github.com/user-attachments/assets/247ae704-92f3-4c0b-afd4-df825864d738)
