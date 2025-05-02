# [Silver V] 지뢰 찾기 - 1996 

[문제 링크](https://www.acmicpc.net/problem/1996) 

### 성능 요약

메모리: 28060 KB, 시간: 412 ms

### 분류

구현

### 제출 일자

2025년 5월 2일 19:05:08

### 문제 설명

<p>다들 windows에서 지원하는 지뢰 찾기 게임을 한번쯤은 해 보았을 것이다. 특히 동호는 지뢰찾기의 매니아로 알려져 있다. 지뢰 찾기 map은 N*N의 정사각형 모양으로 각 칸에는 숫자가 들어가 있거나 지뢰가 들어가 있다. 빈 칸에는 숫자 0이 들어있다고 생각하자.</p>

<p>map의 어떤 칸에 적혀 있는 숫자는, 그 칸과 인접해 있는 여덟 개의 칸 중에서 지뢰가 들어 있는 칸이 몇 개인지를 나타내 준다. 물론 인접한 칸이 map 내부에 있는 경우에 대해서만 생각하면 된다. 예제를 보면 더 잘 이해할 수 있을 것이다.</p>

<p>이번 문제는 조금 업그레이드 된 지뢰 찾기로, 한 칸에 한 개의 지뢰가 있는 것이 아니고, 한 칸에 여러 개(1 이상 9 이하)의 지뢰가 묻혀 있는 게임이다. 따라서 map의 어떤 칸에 적혀 있는 숫자는, 그 칸과 인접해 있는 여덟 개의 칸들에 들어 있는 지뢰의 총 개수가 된다.</p>

<p>이미 windows 지뢰찾기 같은 것을 마스터한 영식이는, map에서 지뢰에 대한 정보만이 주어졌을 때, 영식이는 map을 완성하고 싶다고 한다. N과 지뢰의 위치가 주어졌을 때, 영식이를 도와서 지뢰 찾기 map을 완성하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 1,000)이 주어진다. 다음 N개의 줄에는 지뢰 찾기 map에 대한 정보가 주어지는데 '.' 또는 숫자로 이루어진 문자열이 들어온다. '.'는 지뢰가 없는 것이고 숫자는 지뢰가 있는 경우로 그 칸의 지뢰의 개수이다. 한 줄은 N개의 문자로 이루어져 있다.</p>

### 출력 

 <p>N개의 줄에 걸쳐서 완성된 지뢰 찾기 map을 출력한다. 지뢰는 '*'로 출력하며. 10 이상인 경우는 'M'(Many)으로 출력하면 된다. map은 숫자 또는 'M' 또는 '*'로만 이루어져 있어야 한다.</p>

---

구현

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 팔방면 탐색
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; // 팔방면 탐색
    static int n; 
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n]; // 지뢰판 생성
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                if(str.charAt(j) == '.') continue; // 0이면 건너뜀. 의미 없음
                board[i][j] = str.charAt(j) - '0'; // 숫자면 저장
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                check(i, j); // 탐색 시작
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void check(int x, int y) {
        
        if(board[x][y] != 0) {  // 숫자 1~9라면 지뢰임. '*'을 기록해준다.
            sb.append('*');
            return;
        }
        
        // 지뢰가 아니라면 해당 위치 주위에 지뢰의 개수를 count 해준다.
        
        int cnt = 0;
        
        for(int d=0; d<8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 범위 체크
            
            if(board[nx][ny] != 0) cnt += board[nx][ny]; // 지뢰가 존재한다면, 개수 갱신
        }
        
        char tmp = (cnt >= 10) ? 'M' : (char) (cnt + '0'); // 지뢰가 10개 이상이라면 m, 아니면 지뢰 개수 그대로
        
        sb.append(tmp);
    }
}


```

---

리팩토링 전
```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static char[][] board; // 수정
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                check(i, j);
            }
            System.out.println();
        }
        
    }
    
    static void check(int x, int y) {
        
        if(Character.isDigit(board[x][y])) { 
            System.out.print('*');
            return;
        }
        
        int cnt = 0;
        
        for(int d=0; d<8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(!(nx >= 0 && nx < n && ny >= 0 && ny < n)) continue; // 수정
            
            if(Character.isDigit(board[nx][ny])) cnt += board[nx][ny] - '0';
            
        }
        
        char tmp = (cnt >= 10) ? 'M' : (char) (cnt + '0');
        
        System.out.print(tmp);
    }
}

```

지뢰판 자체를 char에서 int로 바꿔서 char을 int형으로 바꾸는 불필요한 계산을 줄였고,

범위 체크도 좀 더 직관적으로 보이기 위해 겹겹이 쓰지 않게끔 바꿨다.

---

다른 사람 코드에 비해 왜 3500ms 이상이 차이났는데, StringBuilder을 사용하지 않아서 출력 시간이 길어졌던거였음.

![image](https://github.com/user-attachments/assets/666272a5-8ab2-49bf-9b92-ed186f6b4964)
