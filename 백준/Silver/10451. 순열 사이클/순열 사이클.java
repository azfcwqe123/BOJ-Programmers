import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
            
            int n = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            visited = new boolean[n+1];
            int ans = 0;
            
            for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
            
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                int k = Integer.parseInt(st.nextToken());
                graph.get(i).add(k);
            }
            
            
            for(int i=1; i<=n; i++) {
                if(!visited[i]) {
                    DFS(i);
                    ans++;
                }
            }
            
            sb.append(ans + "\n");
            graph.clear();
            Arrays.fill(visited, false);
        }
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int v) {
        
        visited[v] = true;
        
        for(int nv : graph.get(v)) {
            if(!visited[nv]) {
                visited[nv] = true;
                DFS(nv);
            }
        }
    }
    
}



