# [Gold III] 벽 부수고 이동하기 - 2206 

[문제 링크](https://www.acmicpc.net/problem/2206) 

### 성능 요약

메모리: 163416 KB, 시간: 800 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 12일 13:43:33

### 문제 설명

<p>N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.</p>

<p>만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.</p>

<p>한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.</p>

<p>맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.</p>

### 출력 

 <p>첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.</p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int time;
        boolean destoryed;
        
        Point(int x, int y, int time, boolean destoryed) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destoryed = destoryed;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        // 2가지 케이스로 나눠야함. 벽을 부쉈을 경우와 부수지 않은 경우
        // 이유는 반례 때문이다. 코드 밑에 반례 참고
        visited = new boolean[n][m][2]; 
        
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
        pQ.offer(new Point(0, 0, 1, false));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                // 벽을 부순적이 있을 때
                if(cur.destoryed) {
                    if(map[nx][ny] == 0 && !visited[nx][ny][1]) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                
                // 벽을 부순적이 없을 때
                else {
                    if(map[nx][ny] == 1) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, true));
                        visited[nx][ny][1] = true;
                    }
                    
                    else if(map[nx][ny] == 0 && !visited[nx][ny][0]) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, false));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }
        
        return -1;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}


```

---

반례

```
10 4
0000
1110
1100
1001
1011
1000
0000
0110
0101
0100
```
이 반례를 보면, 벽을 먼저 뚫고 지나가고 있다가 벽을 한 번 더 만나면 벽을 뚫지 못하는 경우가 생긴다.

이러한 경우에 벽을 뚫지 않고 지나가고 있던 객체가 길을 찾아야 하는데,

2차원 배열로 방문여부를 체크했다면, 이미 최단경로를 지나가고 있던 객체에 의해 길이 막혀버린다.

그러기에 3차원 배열을 생성해서 2가지의 경우를 만들어야 한다.
&nbsp;

1. 벽을 부쉈던 객체가 지나갈 자리

2. 벽을 부수지 않은 객체가 지나갈 자리

---

![image](https://github.com/user-attachments/assets/0431ef7b-2140-450a-93c7-211c25ccc3e5)

틀렸습니다

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int time;
        int destory;
        
        Point(int x, int y, int time, int destory) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destory = destory;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
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
        
        System.out.print(BFS());
        
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 1, 0));
        visited[0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny) && !visited[nx][ny]) {
                    
                    // 벽을 부수고 가는 경우
                    if(map[nx][ny] == 1 && cur.destory == 0)  {
                        visited[nx][ny] = true;
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destory + 1));
                    }
                    
                    // 그냥 지나가는 경우
                    if(map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destory));
                    }
                }
                
            }
            
        }
        
        return -1;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}


```
반례에 걸려버리는 코드

---

메모리 초과

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int time;
        int destory;
        
        Point(int x, int y, int time, int destory) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destory = destory;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int n, m;
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
        
        System.out.print(BFS());
        
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 1, 0));
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny)) {
                    
                    // 벽을 부수고 가는 경우
                    if(map[nx][ny] == 1 && cur.destory == 0)  {
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destory + 1));
                    }
                    
                    // 그냥 지나가는 경우
                    if(map[nx][ny] == 0) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, cur.destory));
                    }
                }
                
            }
            
        }
        
        return -1;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}


```

방문 여부를 빼버리는 이상한짓을 함
