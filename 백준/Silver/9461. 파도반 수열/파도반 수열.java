import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            long[] dp = new long[n+2];
            
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            
            for(int i=3; i<=n; i++) {
                dp[i] = dp[i-3] + dp[i-2];
            }
            
            System.out.println(dp[n]);
        }
        
    }
    
}

