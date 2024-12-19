import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    private static String[] arr;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> Q = new LinkedList<>();
        
        for(int i=1; i<=n; i++) Q.offer(i);
        
        
        while(!Q.isEmpty()) {
            System.out.print(Q.poll() + " ");
            
            if(Q.size() == 0) break;
            
            Q.offer(Q.poll());
        }
        
    }
    
}

