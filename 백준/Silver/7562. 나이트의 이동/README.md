# [Silver I] 나이트의 이동 - 7562 

[문제 링크](https://www.acmicpc.net/problem/7562) 

### 성능 요약

메모리: 64920 KB, 시간: 272 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 14일 14:01:53

### 문제 설명

<p>체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/knight.png" style="height:172px; width:175px"></p>

### 입력 

 <p>입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.</p>

<p>각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.</p>

### 출력 

 <p>각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.</p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Knight {
    
    int x;
    int y;
    
    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static boolean[][] visited;
    public static int n, x1, y1, x2, y2;
    public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
            
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            
            // 출발 
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            
            // 도착
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            
            if(x1 == x2 && y1 == y2) sb.append(0);
            else sb.append(BFS(x1, y1));
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static int BFS(int x1, int y1) {
        Queue<Knight> Q = new LinkedList<>();
        Q.offer(new Knight(x1, y1));
        visited[x1][y1] = true;
        
        int cnt = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Knight cur = Q.poll();
                
                for(int j=0; j<8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(nx == x2 && ny == y2) return cnt + 1;
                
                    if(rangeCheck(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        Q.offer(new Knight(nx, ny));
                    }
                }    
            }
            cnt++;
        }
        
        return cnt;
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}


```

---

![image](https://github.com/user-attachments/assets/57890fbf-e2f0-4908-bdb9-53e5b41b4a50)
