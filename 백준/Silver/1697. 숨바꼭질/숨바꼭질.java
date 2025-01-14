import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int n, k;
    public static int[] visited = new int[100_001];
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.print((n == k) ? 0 : BFS(n));
    }
    
    public static int BFS(int n) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                int cur = Q.poll();    
                
                int[] move = {cur-1, cur+1, cur*2};
                        
                for(int j=0; j<3; j++) {
                    
                    if(!rangeCheck(move[j])) continue;
                    
                    else if(move[j] == k) return cnt + 1;
                    
                    else if(visited[move[j]] == 0) {
                        visited[move[j]] = 1;
                        Q.offer(move[j]);
                    }
                }
            }
            cnt++; 
        }
        
        return cnt;
    }
    
    public static boolean rangeCheck(int move) {
        return move >= 0 && move <= 100_000;
    } 
    
}

