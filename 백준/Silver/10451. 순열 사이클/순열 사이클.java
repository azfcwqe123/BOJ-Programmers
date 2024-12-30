import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
            
            int n = Integer.parseInt(br.readLine());
            graph = new int[n+1];
            
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            
            visited = new boolean[n+1];
            int ans = 0;
            
            for(int i=1; i<=n; i++) {
                if(!visited[i]) {
                    DFS(i);
                    ans++;
                }
            }
            
            sb.append(ans + "\n");
        }
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int v) {
        
        visited[v] = true;
        
        int next = graph[v];
        
        if(!visited[next]) {
            DFS(next);
        }
        
    }
    
}



