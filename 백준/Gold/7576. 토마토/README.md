# [Gold V] 토마토 - 7576 

[문제 링크](https://www.acmicpc.net/problem/7576) 

### 성능 요약

메모리: 119828 KB, 시간: 560 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 13일 13:19:03

### 문제 설명

<p>철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. </p>

<p style="text-align: center;"><img alt="" src="https://u.acmicpc.net/de29c64f-dee7-4fe0-afa9-afd6fc4aad3a/Screen%20Shot%202021-06-22%20at%202.41.22%20PM.png" style="width: 215px; height: 194px;"></p>

<p>창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.</p>

<p>토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.</p>

### 입력 

 <p>첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.</p>

<p>토마토가 하나 이상 있는 경우만 입력으로 주어진다.</p>

### 출력 

 <p>여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.</p>

---

BFS 풀이

```java
import java.util.*;
import java.io.*;

class Tomato {
    int x;
    int y;
    
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int m, n, ans = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static Queue<Tomato> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                // 익은 토마토가 있으면 바로 넣어줘야함. 익은 토마토들이 동시에 시작해야하기 때문
                if(map[i][j] == 1) Q.offer(new Tomato(i, j)); 
            }
        }
        
        BFS();
        
        // 마지막으로 안익은 토마토가 있는지 탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    System.out.print(-1);
                    System.exit(0);
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void BFS() {
        
        while(!Q.isEmpty()) {
            
            boolean ch = false;
            
            int len = Q.size(); // 사소하지만 중요한 부분. 이렇게 해야 day를 정확히 셀 수 있음
            for(int i=0; i<len; i++) {
                Tomato cur = Q.poll();
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(checkRange(nx, ny) && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        Q.offer(new Tomato(nx, ny));
                        ch = true;
                    }
                }
            }
            
            if(ch) ans++;
        }
        
    }
    
    public static boolean checkRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}

```

---

2차원 배열 탐색 말고 안익었던 토마토 개수와 익은 토마토의 개수를 비교해서 정답 내기

```java
import java.util.*;
import java.io.*;

class Tomato {
    int x;
    int y;
    
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int m, n, ans = 0, unripeT = 0, ripeT = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static Queue<Tomato> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) unripeT++;
                if(map[i][j] == 1) Q.offer(new Tomato(i, j));
            }
        }
        
        BFS();
        
        if(unripeT == ripeT) System.out.print(ans);
        else System.out.print(-1);
        
    }
    
    public static void BFS() {
        
        while(!Q.isEmpty()) {
            
            boolean ch = false;
            
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Tomato cur = Q.poll();
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(checkRange(nx, ny) && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        ripeT++;
                        Q.offer(new Tomato(nx, ny));
                        ch = true;
                    }
                }
            }
            
            if(ch) ans++;
        }
        
    }
    
    public static boolean checkRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}

```

---


![image](https://github.com/user-attachments/assets/e601f354-3b8c-4ba0-9171-dba0e5fd0582)
