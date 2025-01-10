import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] ch;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        ch = new boolean[n+1];
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        DFS(1, 0);
        
        int ans = 0;
        
        for(int i=2; i<ch.length; i++) {
            if(ch[i]) ans++;
        }
        
        System.out.print(ans);
    }
    
    public static void DFS(int v, int cnt) {
        
        if(cnt == 2) return;
        
        for(int nv : graph.get(v)) {
            ch[nv] = true;
            DFS(nv, cnt + 1);
        } 
    }
}

