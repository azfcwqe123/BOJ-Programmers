import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++) stair[i] = Integer.parseInt(br.readLine());
        
        dp[1] = stair[1];
        if(n>1) dp[2] = stair[1] + stair[2];
        if(n>2) dp[3] = Math.max(stair[1], stair[2]) + stair[3];
        
        for(int i=4; i<=n; i++) {
            dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
        }
        
        System.out.print(dp[n]);
        
    }
    
}

