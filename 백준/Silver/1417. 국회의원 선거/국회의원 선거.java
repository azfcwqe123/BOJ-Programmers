import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        
        int n = Integer.parseInt(br.readLine()) - 1;
        
        int k = Integer.parseInt(br.readLine());
        
        if(n == 0) {
            System.out.print(0);
            return;
        } else while(n-- > 0) pQ.offer(Integer.parseInt(br.readLine()));
        
        
        int ans = 0;
        
        while(k <= pQ.peek()) {
            pQ.offer(pQ.poll() - 1);
            k++;
            ans++;
        }
        
        System.out.print(ans);
        
    }
    
}

