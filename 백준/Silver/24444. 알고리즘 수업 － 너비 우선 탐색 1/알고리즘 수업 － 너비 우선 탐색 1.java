import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        visited = new int[n+1];
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(ArrayList<Integer> list : graph) Collections.sort(list);
        
        BFS(r);
        
        for(int i=1; i<=n; i++) System.out.println(visited[i]);
    }
    
    static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);
        int cnt = 1;
        visited[start] = cnt++;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            
            for(int x : graph.get(cur)) {
                if(visited[x] == 0) {
                    Q.offer(x);
                    visited[x] = cnt++;
                }
            }
        }
    }
}

