import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] ch;
    public static int N, M, ans;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
            
            ch = new int[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());    
            
                graph.get(a).add(b);
                graph.get(b).add(a);
            }    
            
            ans = 0;
            
            ch[1] = 1;
            
            BFS();
            
            System.out.println(ans);

        }
        
        
    }
    
    public static void BFS() {
        
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int x : graph.get(cur)) {
                if(ch[x] == 0) {
                    Q.offer(x);
                    ch[x] = 1;
                    ans++;
                }
            }
        }
        
    }
    
}

