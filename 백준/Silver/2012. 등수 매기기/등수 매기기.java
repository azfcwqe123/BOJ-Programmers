import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int i=0; i<n; i++) pQ.offer(Integer.parseInt(br.readLine()));
        
        long ans = 0;
        
        for(int i=1; i<=n; i++) {
            ans += Math.abs(pQ.poll() - i);
        }
        
        System.out.print(ans);
        
    }
}

