import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        int[] dp = new int[N+2];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
            
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            dp[start] += k;
            dp[end + 1] -= k; 
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            dp[i] = dp[i] + dp[i-1];
            sb.append((arr[i] + dp[i]) + " ");
        }
        
        System.out.print(sb);
        
    }
    
}

