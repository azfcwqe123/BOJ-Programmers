import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        parent = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        DFS(1);
        
        for(int i=2; i<=n; i++) sb.append(parent[i]).append('\n');
        
        System.out.print(sb);
    }
    
    static void DFS(int n) {
        
        visited[n] = true;
        
        for(int x : list.get(n)) {
            if(!visited[x]) {
                visited[x] = true;
                parent[x] = n;
                DFS(x);
            }
        }
    }
}

