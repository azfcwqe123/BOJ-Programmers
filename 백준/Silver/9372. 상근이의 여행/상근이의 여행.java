import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[][] graph;
    public static int[] ch;
    public static int N, M, L;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            graph = new int[N+1][N+1];
            ch = new int[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());    
            
                graph[a][b] = 1;
                graph[b][a] = 1;
            }    
            
            ch[1] = 1;
            
            BFS();
            
            System.out.println(L - 1);
        }
        
        
    }
    
    public static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        
        L = 0;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            L++;
            for(int i=1; i<=N; i++) {
                if(graph[cur][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    Q.add(i);
                }
            }
        }
        
    }
    
}

