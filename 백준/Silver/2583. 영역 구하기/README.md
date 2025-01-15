# [Silver I] 영역 구하기 - 2583 

[문제 링크](https://www.acmicpc.net/problem/2583) 

### 성능 요약

메모리: 15860 KB, 시간: 128 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 15일 14:37:21

### 문제 설명

<p>눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.</p>

<p>예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/zzJD2aQyF5Rm4IlOt.png" style="height:224px; width:589px"></p>

<p><그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.</p>

<p>M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.</p>

### 출력 

 <p>첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.</p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static boolean[][] map;
    public static int h, w, k;
    public static int x1, y1, x2, y2;
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    static class Point {        
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[h][w];
        
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int i=y1; i<y2; i++) {
                for(int j=x1; j<x2; j++) {
                    map[i][j] = true;
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(!map[i][j]) {
                    list.add(BFS(i, j));
                    ans++;
                }
            }
        }
        
        Collections.sort(list);
        
        sb.append(ans).append("\n");
        for(int x : list) sb.append(x + " ");
        
        System.out.print(sb);
        
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        int tmp = 1;
        map[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny) && !map[nx][ny]) {
                    map[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                    tmp++;
                }
            }
        }
        
        return tmp;
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < h && ny < w;
    } 
    
}


```

---

DFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static boolean[][] map;
    public static int h, w, k, tmp;
    public static int x1, y1, x2, y2;
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[h][w];
        
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            //직사각형 그리기
            for(int i=y1; i<y2; i++) {
                for(int j=x1; j<x2; j++) {
                    map[i][j] = true;
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(!map[i][j]) {
                    tmp = 1;
                    DFS(i, j);
                    list.add(tmp);
                    ans++;
                }
            }
        }
        
        Collections.sort(list);
        
        sb.append(ans).append("\n");
        for(int x : list) sb.append(x + " ");
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int x, int y) {
        map[x][y] = true;
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(rangeCheck(nx, ny) && !map[nx][ny]) {
                map[nx][ny] = true;
                tmp++;
                DFS(nx, ny);
            }
        }
        
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < h && ny < w;
    } 
    
}


```

---

![image](https://github.com/user-attachments/assets/fa2afdbe-ab3f-4be1-82dc-1928816c35a5)
