import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            pQ.offer(k);
        }
        
        int sum = 0, tmp = 0;
        
        while(pQ.size() > 1) {
            tmp = pQ.poll() + pQ.poll();
            sum += tmp;
            pQ.offer(tmp);
        }
        
        System.out.print(sum);
    }
    
}

