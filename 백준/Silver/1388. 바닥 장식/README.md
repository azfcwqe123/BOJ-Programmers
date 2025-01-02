# [Silver IV] 바닥 장식 - 1388 

[문제 링크](https://www.acmicpc.net/problem/1388) 

### 성능 요약

메모리: 14224 KB, 시간: 104 ms

### 분류

그래프 이론, 그래프 탐색, 구현

### 제출 일자

2025년 1월 2일 22:49:31

### 문제 설명

<p>형택이는 건축가이다. 지금 막 형택이는 형택이의 남자 친구 기훈이의 집을 막 완성시켰다. 형택이는 기훈이 방의 바닥 장식을 디자인했고, 이제 몇 개의 나무 판자가 필요한지 궁금해졌다. 나무 판자는 크기 1의 너비를 가졌고, 양수의 길이를 가지고 있다. 기훈이 방은 직사각형 모양이고, 방 안에는 벽과 평행한 모양의 정사각형으로 나누어져 있다.</p>

<p>이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.</p>

<p>기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다. 둘째 줄부터 N개의 줄에 M개의 문자가 주어진다. 이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다. N과 M은 50 이하인 자연수이다.</p>

### 출력 

 <p>첫째 줄에 문제의 정답을 출력한다.</p>

---

DFS 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static char[][] board;
    public static boolean[][] visited;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        visited = new boolean[n][m];
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) {
                    if(board[i][j] == '-') {
                        DFS_Row(i, j);
                        ans++;
                    }
                    if(board[i][j] == '|') {
                        DFS_Column(i, j);
                        ans++;
                    }
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void DFS_Row(int x, int y) {
        
        visited[x][y] = true;
        
        if(y+1 < m && board[x][y+1] == '-') {
            DFS_Row(x, y+1);
        }
    }
    
    public static void DFS_Column(int x, int y) {
        
        visited[x][y] = true;
        
        if(x+1 < n && board[x+1][y] == '|') {
            DFS_Column(x+1, y);
        }
    }
}


```

---

BFS 풀이

```java
import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static char[][] board;
    public static boolean[][] visited;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        visited = new boolean[n][m];
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) {
                    if(board[i][j] == '-') {
                        BFS_Row(i, j);
                        ans++;
                    }
                    if(board[i][j] == '|') {
                        BFS_Column(i, j);
                        ans++;
                    }
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void BFS_Row(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            visited[cur.x][cur.y] = true;
            
            if(cur.y + 1 < m && board[cur.x][cur.y + 1] == '-') {
                Q.offer(new Point(cur.x, cur.y + 1));
            }
        }
        
    }
    
    public static void BFS_Column(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            visited[cur.x][cur.y] = true;
            
            if(cur.x + 1 < n && board[cur.x + 1][cur.y] == '|') {
                Q.offer(new Point(cur.x + 1, cur.y));
            }
        }
        
    }
}


```

---

이런 문제는 DFS로 푸는게 더 괜찮은듯 싶다. 그래도 BFS로도 풀 수 있다면 두가지 방법 모두 사용해보자

---

![image](https://github.com/user-attachments/assets/7966b356-124e-47e2-9276-1a653665c25a)
