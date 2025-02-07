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

