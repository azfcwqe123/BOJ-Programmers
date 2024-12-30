import java.util.*;
import java.io.*;


class Main { 
    
    public static int n, m, v;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] ch;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); // 정점
        m = Integer.parseInt(st.nextToken()); // 간선 개수 
        v = Integer.parseInt(st.nextToken()); // 탐색 시작
        
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    
        // 인접 리스트 정렬 : 가장 작은 노드부터 탐색해야하기 때문
        for(ArrayList<Integer> x : graph) {
            Collections.sort(x);
        }
        
        ch = new boolean[n+1];
        DFS(v);
        sb.append('\n');
        
        ch = new boolean[n+1];
        BFS(v);
        
        System.out.print(sb);
    }
    
    public static void DFS(int v) {
        
        ch[v] = true;
        sb.append(v + " ");
        
        for(int nv : graph.get(v)) {
            if(!ch[nv]) {
                DFS(nv);
            }
        }
    }    
        
    public static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        ch[v] = true;
        
        while(!Q.isEmpty()) {
            int start = Q.poll();
            sb.append(start + " ");
            
            for(int nv : graph.get(start)) {
                if(!ch[nv]) {
                    Q.offer(nv);
                    ch[nv] = true;
                }
            }
        }
        
    }
    
}

