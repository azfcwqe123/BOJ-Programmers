import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static int n, m, start, end;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(br.readLine());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        DFS(start, 0);
        System.out.print(-1);
    }
    
    public static void DFS(int start, int cnt) {
        
        if(start == end) {
            System.out.print(cnt);
            System.exit(0);
        }
        
        for(int nv : graph.get(start)) {
            if(!visited[nv]) {
                visited[nv] = true;
                DFS(nv, cnt + 1);
            }
        }
        
    }
}

