# [Gold V] 보물섬 - 2589 

[문제 링크](https://www.acmicpc.net/problem/2589) 

### 성능 요약

메모리: 295056 KB, 시간: 460 ms

### 분류

너비 우선 탐색, 브루트포스 알고리즘, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 17일 18:34:25

### 문제 설명

<p>보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/c1bYIsKpI6m317EAx.jpg" style="width: 238px; height: 144px; "></p>

<p>예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/XqDkWCRUWbzZ.jpg" style="width: 238px; height: 144px; "></p>

<p>보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.</p>

### 출력 

 <p>첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.</p>

---

BFS + 브루트포스 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int dis; // 최단거리 찾기위한 필드
        
        Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int n, m;
    public static char[][] map;
    public static boolean[][] visited;
    
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    ans = Math.max(ans, BFS(i, j));
                }
            }
        }
        
        System.out.print(ans);
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y, 0));
        visited[x][y] = true;
        
        int max = 0;
        
        while(!Q.isEmpty()) {
            
            Point cur = Q.poll();
            max = Math.max(cur.dis, max);
                
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                    
                if(checkRange(nx,ny) && map[nx][ny] == 'L' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny, cur.dis + 1));
                }
            }
        }
        
        return max;
        
    }
    
    public static boolean checkRange(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
}


```

---

수정한 풀이는 len = Q.size()을 굳이 만들 필요 없었음.


![image](https://github.com/user-attachments/assets/35738b69-bf44-4bcb-b514-459af34beb8e)
