# [Gold I] 벽 부수고 이동하기 3 - 16933 

[문제 링크](https://www.acmicpc.net/problem/16933) 

### 성능 요약

메모리: 376104 KB, 시간: 2640 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 13일 16:39:32

### 문제 설명

<p>N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다. 이동하지 않고 같은 칸에 머물러있는 경우도 가능하다. 이 경우도 방문한 칸의 개수가 하나 늘어나는 것으로 생각해야 한다.</p>

<p>이번 문제에서는 낮과 밤이 번갈아가면서 등장한다. 가장 처음에 이동할 때는 낮이고, 한 번 이동할 때마다 낮과 밤이 바뀌게 된다. 이동하지 않고 같은 칸에 머무르는 경우에도 낮과 밤이 바뀌게 된다.</p>

<p>만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다. 단, 벽은 낮에만 부술 수 있다.</p>

<p>한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.</p>

<p>맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.</p>

### 출력 

 <p>첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.</p>

---

BFS, 최단경로

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int time;
        int destoryed;
        boolean sun;
        
        Point(int x, int y, int time, int destoryed, boolean sun) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destoryed = destoryed;
            this.sun = sun;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        
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
        pQ.offer(new Point(0, 0, 1, 0, true));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                // 밤, 밤에는 벽 파괴 불가능
                if(!cur.sun) {
                    if(map[nx][ny] == 1) { // 밤인데 벽이 있으면 제자리
                        pQ.offer(new Point(cur.x, cur.y, cur.time + 1, cur.destoryed, true)); // 제자리 + 아침으로 바꿔준다
                    }
                    else if(map[nx][ny] == 0 && !visited[nx][ny][cur.destoryed]) { // 벽이 없으면 이동 
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed, true));
                        visited[nx][ny][cur.destoryed] = true;
                    }
                }
                
                // 낮, 낮에는 벽 파괴 가능
                else {
                    if(map[nx][ny] == 1 && cur.destoryed < k && !visited[nx][ny][cur.destoryed + 1]) { // 벽이 있고, 벽을 지나간적 없다면 부순다. (최단경로 성질에 의해, 벽을 부순곳 탐색하는건 시간낭비)
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed + 1, false));
                        visited[nx][ny][cur.destoryed + 1] = true;
                    }
                    else if(map[nx][ny] == 0 && !visited[nx][ny][cur.destoryed]) { // 벽이 없으면 이동
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed, false));
                        visited[nx][ny][cur.destoryed] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<n && ny<m;
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/cf71a7b2-0975-4454-9c49-e25b2d1eba9d)

