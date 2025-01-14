# [Gold IV] 불 - 5427 

[문제 링크](https://www.acmicpc.net/problem/5427) 

### 성능 요약

메모리: 114900 KB, 시간: 540 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 14일 15:36:35

### 문제 설명

<p>상근이는 빈 공간과 벽으로 이루어진 건물에 갇혀있다. 건물의 일부에는 불이 났고, 상근이는 출구를 향해 뛰고 있다.</p>

<p>매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다. 벽에는 불이 붙지 않는다. 상근이는 동서남북 인접한 칸으로 이동할 수 있으며, 1초가 걸린다. 상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다. 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.</p>

<p>빌딩의 지도가 주어졌을 때, 얼마나 빨리 빌딩을 탈출할 수 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다.</p>

<p>각 테스트 케이스의 첫째 줄에는 빌딩 지도의 너비와 높이 w와 h가 주어진다. (1 ≤ w,h ≤ 1000)</p>

<p>다음 h개 줄에는 w개의 문자, 빌딩의 지도가 주어진다.</p>

<ul>
	<li>'.': 빈 공간</li>
	<li>'#': 벽</li>
	<li>'@': 상근이의 시작 위치</li>
	<li>'*': 불</li>
</ul>

<p>각 지도에 @의 개수는 하나이다.</p>

### 출력 

 <p>각 테스트 케이스마다 빌딩을 탈출하는데 가장 빠른 시간을 출력한다. 빌딩을 탈출할 수 없는 경우에는 "IMPOSSIBLE"을 출력한다.</p>

---

BFS

```java
import java.util.*;
import java.io.*;

class Fire {
    int x;
    int y;
    
    public Fire(int x, int y) {
        this.x = x;
        this.y = y; 
    }
}

class Person {
    int x;
    int y;
    
    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static char[][] map;
    public static int w, h;
    
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static Queue<Person> pQ;
    public static Queue<Fire> fQ;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            // 처음에 int w, int h라 써서 이 부분 잘못된거 찾느라 애먹음.. BFS 코드가 잘못된줄 알고 개고생함
            w = Integer.parseInt(st.nextToken()); 
            h = Integer.parseInt(st.nextToken());
            
            map = new char[h][w];
            
            // 시작할때마다 새로운 큐를 만들어준다. 
            pQ = new LinkedList<>(); // 사람
            fQ = new LinkedList<>(); // 불
            
            for(int i=0; i<h; i++) {
                String str = br.readLine();
                for(int j=0; j<w; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*') fQ.offer(new Fire(i, j)); // 동시 확산이니, 불이 보이는대로 큐에 넣는다.
                    if(map[i][j] == '@') pQ.offer(new Person(i, j));
                }
            }
            
            int ch = BFS();
            
            if(ch == -1) System.out.println("IMPOSSIBLE"); 
            else System.out.println(ch);
            
        }
    }
    
    public static int BFS() {
        
        int cnt = 0;
        
        while(!pQ.isEmpty()) { // 사람을 기준으로 큐를 돌린다. 못빠져나가면 -1이 리턴된다.
            
            int len = fQ.size(); // 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없으니, 불 먼저 확산시킨다. 
            
            for(int i=0; i<len; i++) {
                Fire cur = fQ.poll();
                
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if(rangeCheck(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                        map[nx][ny] = '*';
                        fQ.offer(new Fire(nx, ny));
                    }
                }
            }
            
            len = pQ.size(); // 사람을 이동시킨다.
            
            for(int i=0; i<len; i++) {
                Person cur = pQ.poll();
                
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if(!rangeCheck(nx, ny)) return cnt + 1;
                    
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        pQ.offer(new Person(nx, ny));
                    }
                }
            }
            
            cnt++;
        }
        
        return -1; // 사람이 탈출 못했다면
    }
        
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < h && ny >= 0 && ny < w;
    }
}


```

---

![image](https://github.com/user-attachments/assets/3143d055-aadf-416d-9cc0-521421abeee1)
