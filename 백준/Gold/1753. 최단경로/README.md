# [Gold IV] 최단경로 - 1753 

[문제 링크](https://www.acmicpc.net/problem/1753) 

### 성능 요약

메모리: 109844 KB, 시간: 688 ms

### 분류

데이크스트라, 그래프 이론, 최단 경로

### 제출 일자

2025년 2월 7일 15:09:03

### 문제 설명

<p>방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.</p>

### 출력 

 <p>첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.</p>

---

다익스트라 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist;
    static int INF = (20000 - 1) * 10 + 1; // 정점 개수 20000개, 가중치 최대 10. 노드 1부터 20000까지 가는 최대 가중치값은 (20000 - 1) * 10임. 최댓값의 +1 처리까지 해줘야함
    
    static class Node implements Comparable<Node> {
        int v;
        int cost;
        
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Node ob) {
            return this.cost - ob.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int start = Integer.parseInt(br.readLine()); // 시작 노드
        
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(new Node(e, cost)); // 양방향 아닌 단방향 그래프
        }
        
        dijkst(start); // 다익스트라 시작
        
        for(int i=1; i<=n; i++) {
            if(dist[i] == INF) sb.append("INF"); // 이동할 수 없는 곳이 ex) 아래 그림을 참고해보면 1 -> 5로 가는것은 불가능하다
            else sb.append(dist[i]); 
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dijkst(int start) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pQ.isEmpty()) {
            Node cur = pQ.poll();
            
            for(Node next : graph.get(cur.v)) {
                if(dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pQ.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

```

![image](https://github.com/user-attachments/assets/1773c43b-5ab2-4503-a64a-ec700b97da1a)

다시 보니 그림에 2 -> 3 방향 표기를 안했음 참고할것

---

방문여부 추가

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int INF = (20000 - 1) * 10 + 1;
    
    static class Node implements Comparable<Node> {
        int v;
        int cost;
        
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        public int compareTo(Node ob) {
            return this.cost - ob.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int start = Integer.parseInt(br.readLine());
        
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(new Node(e, cost));
        }
        
        dijkst(start);
        
        for(int i=1; i<=n; i++) {
            if(dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dijkst(int start) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pQ.isEmpty()) {
            Node cur = pQ.poll();
            
            if(!visited[cur.v]) {
                visited[cur.v] = true;
                   for(Node next : graph.get(cur.v)) {
                    if(dist[next.v] > dist[cur.v] + next.cost) {
                        dist[next.v] = dist[cur.v] + next.cost;
                        pQ.offer(new Node(next.v, dist[next.v]));
                    }
                }    
            }
        }
    }
}


```

---
INF의 최댓값 찾는 과정을 계속 돌림

![image](https://github.com/user-attachments/assets/788595d5-f2a2-4bae-b53c-ae55c898efbf)

방문 여부 추가한것이 맨 위
