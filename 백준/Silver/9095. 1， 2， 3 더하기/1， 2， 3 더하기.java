import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        int[] dp = new int[11];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i=4; i<11; i++) dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        
        
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            sb.append(dp[k]);
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
}

