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
            
            if(Find(cur.node1) != Find(cur.node2)) {
                Union(cur.node1, cur.node2);
                ans += cur.cost;
                cnt++;
                
                if(cnt == v-1) break;
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

