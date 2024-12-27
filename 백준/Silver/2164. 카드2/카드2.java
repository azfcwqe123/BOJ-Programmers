import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> Q = new LinkedList<>();
        
        for(int i=1; i<=n; i++) Q.offer(i);
        
        while(Q.size() != 1) {
            Q.poll();
            Q.offer(Q.poll());
        }
        
        System.out.print(Q.poll());
        
    }
}

