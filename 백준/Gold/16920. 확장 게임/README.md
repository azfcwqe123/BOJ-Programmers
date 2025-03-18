# [Gold II] 확장 게임 - 16920 

[문제 링크](https://www.acmicpc.net/problem/16920) 

### 성능 요약

메모리: 71084 KB, 시간: 564 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 18일 23:37:53

### 문제 설명

<p>구사과와 친구들이 확장 게임을 하려고 한다. 이 게임은 크기가 N×M인 격자판 위에서 진행되며, 각 칸은 비어있거나 막혀있다. 각 플레이어는 하나 이상의 성을 가지고 있고, 이 성도 격자판 위에 있다. 한 칸 위에 성이 두 개 이상인 경우는 없다.</p>

<p>게임은 라운드로 이루어져 있고, 각 라운드마다 플레이어는 자기 턴이 돌아올 때마다 성을 확장해야 한다. 제일 먼저 플레이어 1이 확장을 하고, 그 다음 플레이어 2가 확장을 하고, 이런 식으로 라운드가 진행된다.</p>

<p>각 턴이 돌아왔을 때, 플레이어는 자신이 가지고 있는 성을 비어있는 칸으로 확장한다. 플레이어 i는 자신의 성이 있는 곳에서 S<sub>i</sub>칸 만큼 이동할 수 있는 모든 칸에 성을 동시에 만든다. 위, 왼쪽, 오른쪽, 아래로 인접한 칸으로만 이동할 수 있으며, 벽이나 다른 플레이어의 성이 있는 곳으로는 이동할 수 없다. 성을 다 건설한 이후엔 다음 플레이어가 턴을 갖는다.</p>

<p>모든 플레이어가 더 이상 확장을 할 수 없을 때 게임이 끝난다. 게임판의 초기 상태가 주어졌을 때, 최종 상태를 구해보자.</p>

### 입력 

 <p>첫째 줄에 격자판의 크기 N, M과 플레이어의 수 P가 주어진다. 둘째 줄에는 S<sub>1</sub>, S<sub>2</sub>, ...S<sub>P</sub>가 주어진다.</p>

<p>다음 N개의 줄에는 게임판의 상태가 주어진다. '<code>.</code>'는 빈 칸, '<code>#</code>'는 벽, '<code>1</code>', '<code>2</code>', ..., '<code>9</code>'는 각 플레이어의 성이다.</p>

<p>모든 플레이어는 적어도 하나의 성을 가지고 있으며, 게임에 참가하지 않는 플레이어의 성이 있는 경우는 없다.</p>

### 출력 

 <p>플레이어 1이 가진 성의 수, 2가 가진 성의 수, ..., P가 가진 성의 수를 공백으로 구분해 출력한다.</p>

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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, p;
    static char[][] board;
    static int[] range;
    static int[] ans;
    
    // 큐 배열 생성.
    static Queue<Point>[] Q;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        range = new int[p+1];
        ans = new int[p+1];
        board = new char[n][m];
        Q = new Queue[p+1];
        
        for(int i=0; i<=p; i++) Q[i] = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=p; i++) range[i] = Integer.parseInt(st.nextToken());
        
        // 격자판 입력
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    Q[board[i][j] - '0'].offer(new Point(i, j));
                    ans[board[i][j] - '0']++;
                }
            }
        }

        BFS();

        for(int i=1; i<=p; i++) System.out.print(ans[i] + " ");
    }


    static void BFS() {
        
        while(true) {
            
            boolean check = false; // 큐가 한번도 동작되지 않을 경우 true로 변경되면서 while문 종료
            for(int i=1; i<=p; i++) { // i는 플레이어
                int size = Q[i].size(); // 현재 플레이어 성의 개수
                int cycle = 0; // 현재 플레이어 성의 개수만큼 움직여야, 순차적으로 뻗어가기 가능
                
                int cnt = 0;
                int remainCnt = range[i];
                
                // cnt < remainCnt로 움직일 수 있는 횟수만큼 양방향 이동 가능.
                while(!Q[i].isEmpty() && cnt < remainCnt) {
                    
                    Point cur = Q[i].poll();
                    for(int d=0; d<4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                            
                        if(!rangeCheck(nx, ny)) continue;
                            
                        if(board[nx][ny] == '.') {
                            board[nx][ny] = board[cur.x][cur.y];
                            ans[board[nx][ny] - '0']++;
                            Q[i].offer(new Point(nx, ny));
                            check = true;
                        }
                    }
                    cycle++; // 성 한개 뻗어나감
                    
                    if(size == cycle) { // 성 개수만큼 다 채웠으면  
                        cnt++;
                        size = Q[i].size(); // 다음 성들이 양방향으로 뻗어나가기 위한 준비
                        cycle = 0; // 초기화
                    }
                }
            }
            
            if(!check) break; // 한 번도 큐 배열이 동작하지 않은 경우 종료
        }
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
```

---

![image](https://github.com/user-attachments/assets/ca5c4aae-0807-4fd6-885d-993fb68c108a)

---

틀린 풀이1, 백트래킹 이용

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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, p;
    static char[][] board;
    static int[] range;
    static Queue<Point> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        range = new int[p+1];
        board = new char[n][m];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=p; i++) range[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    Q.offer(new Point(i, j));
                }
            }
        }

        BFS();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        int[] count = new int[p+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == '#') continue;
                count[board[i][j] -'0']++;
            }
        }

        for(int i=1; i<=p; i++) System.out.print(count[i] + " ");
    }

    static void DFS(int x, int y, int move, char num) {

        if(move == 0) return;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!rangeCheck(nx, ny)) continue;

            if(board[nx][ny] == '.') {
                board[nx][ny] = num;
                Q.offer(new Point(nx, ny)); 
            }

            DFS(nx, ny, move - 1, num);
        }

    }

    static void BFS() {

        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            int move = range[board[cur.x][cur.y] - '0'];

            DFS(cur.x, cur.y, move, board[cur.x][cur.y]);    
        }

    }

    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
```
테스트 케이스는 모두 통과했다. 하지만 테스트 케이스들의 공통점을 보면, 플레이어 성의 개수들이 모두 오름차순으로 주어진다.

문제의 조건은, 플레이어1부터 순서대로 성을 확장해야 한다.

내 코드가 테스트케이스들을 모두 통과할 수 있었던 이유는, 플레이어들이 오름차순으로 적혀있어서 모두 순차적으로 성을 쌓을 수 있었기에 가능했지만,

플레이어 1, 플레이어 4, 플레이어 1 이런식으로 나오는 순간 순차적으로 성을 쌓지 못하게 된다.

그래서 밑에 우선순위 큐를 사용해서 풀어보았다. 하지만 틀림

---

틀린풀이2, 우선순위큐 이용

```java
import java.util.*;
import java.io.*;

class Main {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        char num; // 번호
        int cnt; // 우선순위

        Point(int x, int y, char num, int cnt) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point ob) {
            if(this.cnt == ob.cnt) return this.num - ob.num;
            else return this.cnt - ob.cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, p;
    static char[][] board;
    static int[] range;
    static PriorityQueue<Point> pQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        range = new int[p+1];
        board = new char[n][m];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=p; i++) range[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    pQ.offer(new Point(i, j, board[i][j], 0));
                }
            }
        }

        BFS();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[] count = new int[p+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == '#' || board[i][j] == '.') continue;
                count[board[i][j] -'0']++;
            }
        }

        for(int i=1; i<=p; i++) System.out.print(count[i] + " ");
    }

    static void DFS(int x, int y, int move, char num, int cnt) {

        if(move == 0) return;

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!rangeCheck(nx, ny)) continue;

            if(board[nx][ny] == '.') {
                board[nx][ny] = num;
                pQ.offer(new Point(nx, ny, num, cnt + 1));
                DFS(nx, ny, move - 1, num, cnt + 1);
            }

        }

    }

    static void BFS() {
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            System.out.println(cur.num + " " + cur.cnt + " x : " + cur.x + " y : " + cur.y);
            int move = range[cur.num - '0'];
            DFS(cur.x, cur.y, move, cur.num, cur.cnt);
        }
    }

    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
```

```
1 0 x : 0 y : 0
1 0 x : 0 y : 3
2 0 x : 3 y : 3
1 1 x : 0 y : 1
1 1 x : 1 y : 0
1 1 x : 1 y : 3
2 1 x : 3 y : 2
1 2 x : 1 y : 2
1 2 x : 0 y : 2
1 2 x : 2 y : 0
1 2 x : 1 y : 1
1 2 x : 2 y : 3
2 2 x : 2 y : 2
2 2 x : 3 y : 1
1 3 x : 3 y : 0
1 3 x : 2 y : 1
1 1 1 1 
1 1 1 1 
1 1 2 1 
1 2 2 2 

12 4 
```

우선순위큐로 풀면 안된다. 

1 2 x : 1 y : 2
1 2 x : 0 y : 2
1 2 x : 2 y : 0
1 2 x : 1 y : 1
1 2 x : 2 y : 3

이 성들이 

2 1 x : 3 y : 2

이 성보다 앞에 와있어야 하는데, 우선순위큐 정렬에 의해서 꼬여버리는것을 확인할 수 있다.

---

참고 : https://passionfruit200.tistory.com/976
