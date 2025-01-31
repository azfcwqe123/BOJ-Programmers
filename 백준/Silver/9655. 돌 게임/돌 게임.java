import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        
        for(int i=4; i<=1000; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-1]) + 1;
        }
        
        String ans = dp[n] % 2 == 0 ? "CY" : "SK";
        
        System.out.print(ans);
    }
    
}

