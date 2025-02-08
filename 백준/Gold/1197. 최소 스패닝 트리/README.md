# [Gold IV] 최소 스패닝 트리 - 1197 

[문제 링크](https://www.acmicpc.net/problem/1197) 

### 성능 요약

메모리: 51492 KB, 시간: 504 ms

### 분류

최소 스패닝 트리, 그래프 이론

### 제출 일자

2025년 2월 8일 15:08:20

### 문제 설명

<p>그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.</p>

<p>최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.</p>

<p>그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.</p>

### 출력 

 <p>첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.</p>

---

크루스칼 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Node implements Comparable<Node> {
        int node1;
        int node2;
        long cost;
        
        Node(int node1, int node2, long cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node ob) {
            if(this.cost > ob.cost) return 1;
            else if(this.cost < ob.cost) return -1;
            else return 0;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] unf;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        unf = new int[v+1];
        for(int i=1; i<=v; i++) unf[i] = i;
        
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        
        while(e-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            
            pQ.offer(new Node(node1, node2, cost));
        }
        
        int cnt = 0;
        long ans = 0;
        
        while(!pQ.isEmpty()) {
            Node cur = pQ.poll();
            
            if(Find(cur.node1) != Find(cur.node2)) { // 같은 집합에 연결하면 사이클이 돌아버림.
                Union(cur.node1, cur.node2); // 같은 집합이 아니라면 노드를 연결시켜준다.
                ans += cur.cost;
                cnt++;
                
                if(cnt == v-1) break; // 최소 스패닝 트리의 성질 이용(간선이 정점의 v-1개여야 사이클이 돌지않는다. v개면 사이클이 돌 수 있다.)
            }
        }
        
        System.out.print(ans);
        
    }
    
    static void Union(int node1, int node2) {
        int fa = Find(node1);
        int fb = Find(node2);
        
        if(fa != fb) unf[fa] = fb;
    }
    
    static int Find(int e) {
        if(unf[e] == e) return e;
        else return unf[e] = Find(unf[e]);
    }
}


```

참고: https://kloong.tistory.com/entry/%EC%95%BC%EB%A7%A4-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Kruskal-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-MST-%EC%B0%BE%EA%B8%B0-%EB%B0%B1%EC%A4%80-1197-%EC%B5%9C%EC%86%8C-%EC%8A%A4%ED%8C%A8%EB%8B%9D-%ED%8A%B8%EB%A6%AC

블로그가 설명 굳

![image](https://github.com/user-attachments/assets/6f4f2dcc-2adf-485b-a231-31094fb549e8)

스패닝 트리란? -> 그래프 내의 모든 정점을 포함하지만 사이클이 없는 트리로, 신장 트리라고도 한다

최소 스패닝 트리란? -> 모든 정점을 연결하는 트리 중에서 간선들의 가중치 합이 최소가 되는 트리

&nbsp;

\+ 스패닝 트리든 최소 스패닝 트리든, 간선의 수는 항상 v-1개이다. (v는 정점의 개수)

---

프림 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Node implements Comparable<Node> {
 
        int to;
        long cost;
        
        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node ob) {
            if(this.cost > ob.cost) return 1;
            else if(this.cost < ob.cost) return -1;
            else return 0;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static long ans = 0;
    static int v, e, cnt = 0;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        visited = new boolean[v+1];
        for(int i=0; i<=v; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }
        
        prim(1);
        
        System.out.print(ans);
    }
    
    static void prim(int start) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        
        pQ.offer(new Node(start, 0));
        
        while(!pQ.isEmpty()) {
            Node cur = pQ.poll();
            
            int node = cur.to;
            long cost = cur.cost;
            
            if(visited[node]) continue;
            
            visited[node] = true;
            ans += cost;
            
            /*cnt++;
            if(cnt == v) break;*/ // 모든 정점을 돌았을때. 최소 스패닝 트리는 v-1개이지만, 이건 간선이 아니기 때문에 v로 놓았음
            // 이 코드가 추가돼도 정답은 똑같다.
            
            for(Node next : graph.get(node)) {
                if(!visited[next.to]) {
                    pQ.offer(next);
                }
            }
        }
    }
}

```

프림 알고리즘 : https://www.weeklyps.com/entry/%ED%94%84%EB%A6%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Prims-algorithm

다익스트라 알고리즘과 비슷하지만, 차이가 있다.

&nbsp;

프림 알고리즘: 그래프의 모든 노드를 연결하는 최소 신장 트리를 구할 때 사용

다익스트라 알고리즘: 한 지점에서 다른 지점으로 가는 최소 비용을 구할때 사용
