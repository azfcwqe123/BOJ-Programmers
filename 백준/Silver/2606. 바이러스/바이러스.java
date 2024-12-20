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
        
        BFS();
        
        System.out.print(ans);
    }
    
    public static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        
        ch[1] = true;
        Q.offer(1);
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                int cur = Q.poll();
                
                for(int x : graph.get(cur)) {
                    if(!ch[x]) {
                        Q.offer(x);
                        ch[x] = true;
                        ans++;
                    }
                }
            }
        }
        
    }
    
}

