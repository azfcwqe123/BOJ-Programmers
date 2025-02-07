import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int INF = 50000 * 1000 + 1;
    
    static class Node implements Comparable<Node> {
        int v;
        int cost;
        
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node ob) {
            return this.cost - ob.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(s).add(new Node(e, cost));
            graph.get(e).add(new Node(s, cost));
        }
        
        dijkst();
        
        System.out.print(dist[n]);
        
    }
    
    static void dijkst() {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.offer(new Node(1, 0));
        dist[1] = 0;
        
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

