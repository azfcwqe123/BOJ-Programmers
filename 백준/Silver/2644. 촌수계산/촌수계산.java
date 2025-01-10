import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static int n, m, start, end;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] dist;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        dist = new int[n+1];
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
        
        System.out.print(BFS(start));
    }
    
    public static int BFS(int start) {
        
        Queue<Integer> Q = new LinkedList<>();
        visited[start] = true;
        Q.offer(start);
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            
            for(int i=0; i<graph.get(cur).size(); i++) {
                int k = graph.get(cur).get(i);
                if(!visited[k]) {
                    dist[k] = dist[cur] + 1;
                    if(k == end) {
                        return dist[k];
                    }
                    Q.offer(k);
                    visited[k] = true;
                }
            }
        }
        
        return -1;
    }
}

