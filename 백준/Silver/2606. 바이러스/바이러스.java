import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] ch;
    private static int N, M, ans;
    
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        ch = new boolean[N+1];
        
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        DFS(1);
        
        System.out.print(ans);
    }
    
    public static void DFS(int v) {
        ch[v] = true;
        
        for(int x : graph.get(v)) {
            if(!ch[x]) {
                ans++;
                DFS(x);
            }
        }
        
    }
    
}

