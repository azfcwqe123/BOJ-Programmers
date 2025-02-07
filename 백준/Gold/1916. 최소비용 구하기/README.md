# [Gold V] 최소비용 구하기 - 1916 

[문제 링크](https://www.acmicpc.net/problem/1916) 

### 성능 요약

메모리: 50608 KB, 시간: 476 ms

### 분류

데이크스트라, 그래프 이론, 최단 경로

### 제출 일자

2025년 2월 7일 16:04:05

### 문제 설명

<p>N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.</p>

### 입력 

 <p>첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.</p>

<p>그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.</p>

### 출력 

 <p>첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.</p>

---

다익스트라 알고리즘(중요)

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int INF = (1000 - 1) * 100000 + 1;
    
    static class Node implements Comparable<Node>{
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
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(new Node(e, cost));
        }
        
        st = new StringTokenizer(br.readLine());
            
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        dijkst(start);
        
        System.out.print(dist[end]);
    }
    
    static void dijkst(int start) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        dist[start] = 0;
        pQ.offer(new Node(start, 0));
        
        while(!pQ.isEmpty()) {
            Node cur = pQ.poll();
            
            if(!visited[cur.v]) { // 방문여부가 없으면 시간초과가 발생한다.
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

그 전에 다익스트라 알고리즘을 2문제 정도 풀었었는데, 이번 문제를 계기로 다익스트라 알고리즘이 어떤 원리로 돌아가는지 제대로 알 수 있는 기회를 가졌다.

다른 다익스트라 알고리즘들은 방문 여부를 쓰지 않아도 문제가 풀렸는데, 따로 다시 풀어봐야겠다

참고: https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-1916%EB%B2%88-%EC%B5%9C%EC%86%8C%EB%B9%84%EC%9A%A9-%EA%B5%AC%ED%95%98%EA%B8%B0-java 

---

![image](https://github.com/user-attachments/assets/da85fb1a-9ca8-4fef-8902-e15d123b54bf)
