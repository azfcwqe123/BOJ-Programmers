import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static long A, B;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        long k = BFS(A);
        
        System.out.print(k == -1 ? -1 : k);
    }
    
    public static int BFS(long A) {
        Queue<Long> Q = new LinkedList<>();
        Q.offer(A);
        
        int ans = 0;
        
        while(!Q.isEmpty()) {
            long len = Q.size();
            
            for(int i=0; i<len; i++) {
                long cur = Q.poll();
                
                if(cur == B) return ans + 1;
                
                long a = cur * 2;
                long b = Long.parseLong(String.valueOf(cur) + "1");
                
                if(a <= B) {
                    Q.offer(a);
                }
                
                if(b <= B) {
                    Q.offer(b);
                }
            }
            ans++;
        }
        return -1;
    }
    
}

