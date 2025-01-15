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

