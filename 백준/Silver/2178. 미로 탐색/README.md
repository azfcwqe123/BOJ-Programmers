# [Silver I] 미로 탐색 - 2178 

[문제 링크](https://www.acmicpc.net/problem/2178) 

### 성능 요약

메모리: 14684 KB, 시간: 120 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 13일 21:03:43

### 문제 설명

<p>N×M크기의 배열로 표현되는 미로가 있다.</p>

<table class="table table-bordered" style="width:18%">
	<tbody>
		<tr>
			<td style="width:3%">1</td>
			<td style="width:3%">0</td>
			<td style="width:3%">1</td>
			<td style="width:3%">1</td>
			<td style="width:3%">1</td>
			<td style="width:3%">1</td>
		</tr>
		<tr>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
		</tr>
		<tr>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>1</td>
		</tr>
		<tr>
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>0</td>
			<td>1</td>
			<td>1</td>
		</tr>
	</tbody>
</table>

<p>미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.</p>

<p>위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.</p>

### 입력 

 <p>첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 <strong>붙어서</strong> 입력으로 주어진다.</p>

### 출력 

 <p>첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.</p>

---

BFS, 최단경로

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
    
    public static int[][] map;
    public static int n, m, ans = 1;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        BFS();
        
        System.out.print(map[n-1][m-1]);
    }
    
    public static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0));
        
        while(!Q.isEmpty()) {
            
            Point cur = Q.poll();
            
            for(int i=0; i<4; i++) {
                
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
                
            }
        }
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
    
}


```

---

DFS 시도(풀 수 없음)

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
    
    public static int[][] map;
    public static boolean[][] visited;
    public static int n, m, ans = 1;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        visited[0][0] = true;
        DFS(0, 0);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.print(map[n-1][m-1]);
    }
    
    public static void DFS(int x, int y) {
        
        if(x == n-1 && y == m-1) return;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(rangeCheck(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                map[nx][ny] = map[x][y] + 1;
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
        
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
    
}


```

DFS 풀리지 않는 이유는, 깊이 우선 탐색인것처럼 한 방향으로만 쭉 가는 방식을 사용하기 때문에 최단경로를 찾는데 적합하지 않다.

BFS로 풀리는 이유는, 상하좌우를 골고루 탐색하면서 가기에 최단경로를 찾는데 적합하다.

&nbsp;

즉, 최단 경로 문제는 BFS로 푸는게 맞다.



---

![image](https://github.com/user-attachments/assets/e34f25d0-2f8b-46bc-80e9-1e794e162688)
