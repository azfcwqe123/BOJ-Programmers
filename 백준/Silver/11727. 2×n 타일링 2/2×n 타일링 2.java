import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i=3; i<=n; i++) dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
        
        System.out.print(dp[n]);
    }
    
}

