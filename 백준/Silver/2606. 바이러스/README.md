# [Silver III] 바이러스 - 2606 

[문제 링크](https://www.acmicpc.net/problem/2606) 

### 성능 요약

메모리: 14248 KB, 시간: 104 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 12월 20일 15:00:04

### 문제 설명

<p>신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.</p>

<p>예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/zmMEZZ8ioN6rhCdHmcIT4a7.png" style="width: 239px; height: 157px; "></p>

<p>어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.</p>

### 출력 

 <p>1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.</p>


---

BFS + 인접리스트

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] ch; // 방문 여부
    private static int N, M, ans;
    
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        ch = new boolean[N+1];
        
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 컴퓨터끼리 서로 연결돼있으니, 양방향 그래프를 사용한다.
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        BFS();
        
        System.out.print(ans);
    }
    
    public static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        
        ch[1] = true; // 첫번째 컴퓨터부터 시작하니, 이미 감염돼있는 상태
        Q.offer(1); // 첫번째 컴퓨터를 큐에 넣어놓는다.
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                int cur = Q.poll(); // 감염된 컴퓨터를 꺼낸다
                
                for(int x : graph.get(cur)) { // 감염된 컴퓨터와 연결된 컴퓨터들을 꺼낸다
                    if(!ch[x]) {  // 연결된 컴퓨터 중에서 감염돼있지 않다면
                        Q.offer(x); // 큐에 넣는다.
                        ch[x] = true; // 감염 표시를 한다.
                        ans++;
                    }
                }
            }
        }
        
    }
    
}

```

---

DFS + 인접리스트

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] ch;
    private static int N, M, ans;
    
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        ch = new boolean[N+1];
        
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        DFS(1);
        
        System.out.print(ans);
    }
    
    public static void DFS(int v) {
        ch[v] = true;
        
        for(int x : graph.get(v)) {
            if(!ch[x]) {
                ans++;
                DFS(x);
            }
        }
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/b5c2e0c8-c9b4-4226-94da-9c706eaa27cf)
