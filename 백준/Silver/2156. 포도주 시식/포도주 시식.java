import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] wine = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) wine[i] = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++) {
            
            if(i==1) dp[i] = wine[i];
            else if(i==2) dp[i] = wine[i] + wine[i-1];
            else dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
        }
        
        System.out.println(dp[n]);
    }
    
}

