import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static int[][] graph;
    public static boolean[] visited;
    public static int n, m, ans = 0;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a][b] = graph[b][a] = 1;
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) { // 핵심
                DFS(i);
                ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void DFS(int v) {
        
        visited[v] = true;
        
        for(int i=1; i<=n; i++) {
            if(graph[v][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
        
    }
    
}
    


