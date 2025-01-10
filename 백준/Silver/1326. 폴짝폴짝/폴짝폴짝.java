import java.util.*;
import java.io.*;

class Frog {
    
    int pos;
    int count;
    
    public Frog(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int[] bridge;
    public static int n;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        bridge = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        System.out.print(BFS(start, end));
    }
    
    public static int BFS(int start, int end) {
        
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        
        Queue<Frog> Q = new LinkedList<>();
        Q.offer(new Frog(start, 0));
        
        while(!Q.isEmpty()) {
            Frog cur = Q.poll();
            
            if(cur.pos == end) return cur.count;
            
            int jump = bridge[cur.pos];
            
            for(int i=cur.pos; i>=1; i -= jump) {
                if(visited[i]) continue;
                visited[i] = true;
                Q.offer(new Frog(i, cur.count + 1));
            }
            
            for(int i=cur.pos; i<=n; i += jump) {
                if(visited[i]) continue;
                visited[i] = true;
                Q.offer(new Frog(i, cur.count + 1));
            }
            
        }
        
        return -1;
    }
}

