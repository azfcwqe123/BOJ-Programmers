# [Gold III] 다리 만들기 - 2146 

[문제 링크](https://www.acmicpc.net/problem/2146) 

### 성능 요약

메모리: 139156 KB, 시간: 292 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 14일 13:49:00

### 문제 설명

<p>여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.</p>

<p>이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.</p>

<p style="text-align: center;"><img alt="" height="225" src="https://www.acmicpc.net/JudgeOnline/upload/201008/bri.PNG" width="243"></p>

<p>위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.</p>

<p style="text-align: center;"><img alt="" height="220" src="https://www.acmicpc.net/JudgeOnline/upload/201008/b2.PNG" width="247"></p>

<p>물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).</p>

<p>지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.</p>

### 입력 

 <p>첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.</p>

### 출력 

 <p>첫째 줄에 가장 짧은 다리의 길이를 출력한다.</p>

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
        
        // 최단 경로 탐색용
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        // 섬 번호 부여용
        Point(int x, int y) {
            this(x, y, 0);
        }
        
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, ans = 10000000;
    static int[][] map;
    static boolean[][] visited;
    static int setLandNum = 1; // 섬의 번호
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        
        // 맵 입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 섬에 번호 부여하기 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    setLand(i, j, setLandNum); // 섬의 번호를 1번부터 부여 시작
                }
            }
        }
        
        // 다리 만들기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] != 0) {
                    visited = new boolean[n][n];
                    makeBridge(i, j, map[i][j]); // map[i][j] = 현재 섬의 번호
                }
            }
        }
        
        System.out.println(ans);
    }
    
    static void setLand(int x, int y, int num) {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(x, y));
        map[x][y] = num;
        visited[x][y] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                    pQ.offer(new Point(nx, ny));
                }
            }
        }
        setLandNum++; // 섬의 번호 다 부여했으면 다음 번호로
    }
    
    static void makeBridge(int x, int y, int land) {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(x, y));
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                // 다른 섬 발견
                if(map[nx][ny] != 0 && map[nx][ny] != land) { 
                    ans = Math.min(ans, cur.time); // 최솟값 갱신
                    return; // 리턴
                }
                
                // 다리 건설중
                if(map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pQ.offer(new Point(nx, ny, cur.time + 1));
                }
                
            }
            
        }
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<n && ny<n;
    }
    
}


```

1. 초기에 모든 섬이 1로 주어진다. 이러면 각각의 섬을 탐색하기에 어려움이 생기니 고유의 섬 번호를 부여해주는게 좋다.

2. 섬 번호 부여 -> 다리 만들기 순으로 알고리즘을 생각해낸다.
---

![image](https://github.com/user-attachments/assets/9fdbdc05-5a75-4861-847f-e03b4c1e66cb)

---

태그에 브루트포스 알고리즘이 없길래, 어떻게하지 고민하다가, 결국엔 브루트포스 알고리즘과 유사한 느낌을 내는 문제였다는걸 알았다.

태그에 없는 알고리즘이어도 시도는 꼭 해보자
