import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mQ = new PriorityQueue<>();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            if(k > 0) pQ.offer(k);
            else mQ.offer(k);
        }
        
        
        solution(pQ);
        solution(mQ);
        
        int a = 0, b = 0;
        
        if(!pQ.isEmpty() && !mQ.isEmpty()) {
            a = pQ.poll();
            b = mQ.poll();
            
            ans += Math.max(a * b, a + b);
        }
        
        else if(!pQ.isEmpty()) ans += pQ.poll();
        else if(!mQ.isEmpty()) ans += mQ.poll();
        
        System.out.print(ans);
        
    }
    
    static void solution(PriorityQueue<Integer> Q) {
        
        int a = 0, b = 0;
        
        while(Q.size() > 1) {
            a = Q.poll();
            b = Q.poll();
            
            ans += Math.max(a * b, a + b);
        }
    }
    
}

