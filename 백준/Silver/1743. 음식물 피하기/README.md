# [Silver I] 음식물 피하기 - 1743 

[문제 링크](https://www.acmicpc.net/problem/1743) 

### 성능 요약

메모리: 15920 KB, 시간: 132 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 21일 22:23:34

### 문제 설명

<p>코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. </p>

<p>이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. </p>

<p>통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. </p>

<p>선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.</p>

### 입력 

 <p>첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.  그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.</p>

<p>좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.</p>

### 출력 

 <p>첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.</p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k;
    static boolean[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[n][m];
        
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            
            map[r][c] = true;
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == true) ans = Math.max(ans, BFS(i, j));
            }
        }
        
        System.out.print(ans);
    }
    
    static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        map[x][y] = false;
        
        int cnt = 0; // 핵심
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            cnt++; 
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                if(map[nx][ny] == true) {
                    Q.offer(new Point(nx, ny));
                    map[nx][ny] = false;
                }
            }
        }
        
        return cnt;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}


```

---

DFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k, cnt;
    static boolean[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[n][m];
        
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            
            map[r][c] = true;
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == true) {
                    cnt = 0;
                    DFS(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        
        System.out.print(ans);
    }
    
    static void DFS(int x, int y) {
        map[x][y] = false;
        cnt++;
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(!rangeCheck(nx, ny)) continue;
            
            if(map[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}


```

---

