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

