# [Gold III] 불! - 4179 

[문제 링크](https://www.acmicpc.net/problem/4179) 

### 성능 요약

메모리: 72848 KB, 시간: 544 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 15일 13:50:27

### 문제 설명

<p>지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!</p>

<p>미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.</p>

<p>지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다)  이동한다. </p>

<p>불은 각 지점에서 네 방향으로 확산된다. </p>

<p>지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다. </p>

<p>지훈이와 불은 벽이 있는 공간은 통과하지 못한다.</p>

### 입력 

 <p>입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.</p>

<p>다음 입력으로 R줄동안 각각의 미로 행이 주어진다.</p>

<p> 각각의 문자들은 다음을 뜻한다.</p>

<ul>
	<li>#: 벽</li>
	<li>.: 지나갈 수 있는 공간</li>
	<li>J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)</li>
	<li>F: 불이 난 공간</li>
</ul>

<p>J는 입력에서 하나만 주어진다.</p>

### 출력 

 <p>지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.</p>

<p>지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다. </p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    static class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int n, m;
    public static char[][] map;
    public static Queue<Pos> fQ = new LinkedList<>();
    public static Queue<Pos> pQ = new LinkedList<>();
    
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') pQ.offer(new Pos(i, j));
                if(map[i][j] == 'F') fQ.offer(new Pos(i, j));
            }
        }
        
        int ans = BFS();
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
        
    }
    
    public static int BFS() {
        
        int cnt = 0;
        
        // 저번 문제와 달리, 이 문제는 '지훈이가 불에 타기전에' 탈출할 수 있는지 여부가 핵심이다.
        while(!pQ.isEmpty()) {
            
            int len = pQ.size(); // 불에 타기전에 탈출해야하니, 지훈이가 먼저 움직인다.
            
            for(int i=0; i<len; i++) {
                Pos cur = pQ.poll();
                
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];    
                    
                    // 탈출하려고 할 때, 현재 위치에 불이 있으면 탈출하지 못함
                    if(!rangeCheck(nx, ny) && map[cur.x][cur.y] != 'F') return cnt + 1; // 탈출 성공
                    
                    // 지훈이가 빈공간으로 이동
                    if(rangeCheck(nx, ny) && map[nx][ny] == '.') {
                        map[nx][ny] = 'J';
                        pQ.offer(new Pos(nx, ny));
                    }    
                }
            }
            cnt++; // 지훈이가 한 칸 이동함
            
            len = fQ.size(); // 불 번지기 시작
            for(int i=0; i<len; i++) {
                Pos cur = fQ.poll();
                
                int tmp = 0;
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];    
                    
                    // 빈공간이나 지훈이가 있는 위치로 불이 번진다.
                    if(rangeCheck(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'J')) { 
                        map[nx][ny] = 'F';
                        fQ.offer(new Pos(nx, ny));
                    }
                }
            }
            
        }
        
        return -1; // 탈출하지 못했다면 -1 리턴
        
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}


```

---

반례찾는데 도움됐던 블로그: https://yinq.tistory.com/153

![image](https://github.com/user-attachments/assets/8fa5060e-a733-4cd9-9bd3-bd7247c418db)
