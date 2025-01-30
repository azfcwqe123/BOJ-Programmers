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
            
            int[][] dp = new int[41][2];
            
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
        
            for(int i=2; i<=n; i++) {
                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];
            }
            
            sb.append(dp[n][0] + " " + dp[n][1]).append('\n'); 
        }
        
        System.out.print(sb);
    }
    
}

