# [Silver I] 스타트링크 - 5014 

[문제 링크](https://www.acmicpc.net/problem/5014) 

### 성능 요약

메모리: 58608 KB, 시간: 192 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 15일 19:16:07

### 문제 설명

<p>강호는 코딩 교육을 하는 스타트업 <a href="https://startlink.io">스타트링크</a>에 지원했다. 오늘은 강호의 면접날이다. 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.</p>

<p>스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.</p>

<p>보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)</p>

<p>강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.</p>

### 입력 

 <p>첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.</p>

### 출력 

 <p>첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력한다. 만약, 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력한다.</p>

---

BFS 첫번째 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int F, S, G, U, D;
    public static boolean[] visited;
    public static int[] move;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        move = new int[] {U, -D};
        
        visited = new boolean[F+1];
        
        int ans = BFS(S);
        
        if(S == G) System.out.print(0);
        else System.out.print(ans == -1 ? "use the stairs" : ans);
    }
    
    public static int BFS(int S) {
        Queue<Integer> Q = new LinkedList<>();
        visited[S] = true;
        Q.offer(S);
        
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                int cur = Q.poll();
                
                for(int d=0; d<2; d++) {
                    int k = cur + move[d];
                    
                    if(k == G) return cnt + 1;
                    
                    if(rangeCheck(k) && !visited[k]) {
                        visited[k] = true;
                        Q.offer(k);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    
    public static boolean rangeCheck(int k) {
        return k > 0 && k <= F;
    }
}


```

---

BFS 두번째 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int F, S, G, U, D;
    public static boolean[] visited;
    public static int[] dir, move;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        dir = new int[] {U, -D};
        
        visited = new boolean[F+1];
        move = new int[F+1];
        
        BFS(S);
    }
    
    public static void BFS(int S) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(S);
        visited[S] = true;
        move[S] = 0;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
                
            if(cur == G) {
                System.out.println(move[cur]);
                return;
            }
                
            for(int d=0; d<2; d++) {
                int k = cur + dir[d];
                    
                if(rangeCheck(k) && !visited[k]) {
                    visited[k] = true;
                    Q.offer(k);
                    move[k] = move[cur] + 1;
                }
            }
        }
        
        System.out.println("use the stairs");
    }
    
    public static boolean rangeCheck(int k) {
        return k > 0 && k <= F;
    }
}


```

---

어떤 방식으로 풀든 취향차이지만, 두가지 풀이법은 확실히 알고 있는게 좋을거같다고 판단했다.

![image](https://github.com/user-attachments/assets/4e131c9c-e69f-4c7c-98d8-60d78e52a469)
