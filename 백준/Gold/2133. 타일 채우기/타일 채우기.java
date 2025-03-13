import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        if(n % 2 != 0) {
            System.out.print(0);
            System.exit(0);
        }
        
        int[] dp = new int[n+1];
        
        dp[2] = 3;
        
        for(int i=4; i<=n; i+=2) {
            dp[i] = dp[i-2] * dp[2];
            for(int j=i-4; j >=0; j-=2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2;
        }
        
        System.out.print(dp[n]);
    
    }
    
}

