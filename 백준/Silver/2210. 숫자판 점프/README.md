# [Silver II] 숫자판 점프 - 2210 

[문제 링크](https://www.acmicpc.net/problem/2210) 

### 성능 요약

메모리: 15880 KB, 시간: 124 ms

### 분류

브루트포스 알고리즘, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 9일 21:34:52

### 문제 설명

<p>5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.</p>
<p>숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.</p>

### 출력 

 <p>첫째 줄에 만들 수 있는 수들의 개수를 출력한다.</p>

---

DFS, 4개의 매개변수 이용, 124ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static String[][] board = new String[5][5];
    public static HashSet<String> set = new HashSet<>();
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        
        
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                board[i][j] = st.nextToken();
            }
        }
        
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                DFS(i, j, board[i][j], 1);
            }
        }
        
        System.out.print(set.size());
        
    }
    
    public static void DFS(int x, int y, String tmp, int cnt) {
        
        if(cnt == 6) {
            set.add(tmp);
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            
            if(nX >= 0 && nX < 5 && nY >= 0 && nY < 5) {
                DFS(nX, nY, tmp + board[nX][nY], cnt + 1);
            }
        }
        
    }
    
}


```

---

DFS, ch 배열 사용, 156ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[][] board = new int[5][5];
    public static HashSet<String> set = new HashSet<>();
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static int[] ch = new int[6];
    
    public static void main(String[] args) throws IOException {
        
        
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                DFS(i, j, 0);
            }
        }
        
        System.out.print(set.size());
        
    }
    
    public static void DFS(int x, int y, int cnt) {
        
        if(cnt == 6) {
            StringBuilder sb = new StringBuilder();
            for(int v : ch) sb.append(v);
            set.add(sb.toString());
            return;
        }
        
        ch[cnt] = board[x][y];
        
        for(int i=0; i<4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            
            if(nX >= 0 && nX < 5 && nY >= 0 && nY < 5) {
                DFS(nX, nY, cnt + 1);
            }
        }
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/7196de3f-a80f-4877-9c30-6a8eea06bfe5)

