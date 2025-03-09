import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int mod = 1000000000;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[n+1][10];
        
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=2; i<=n; i++) {
            
            for(int j=0; j<=9; j++) {
                
                if(j == 0) dp[i][0] = dp[i-1][1] % mod;
                
                else if(j == 9) dp[i][9] = dp[i-1][8] % mod;
                
                else dp[i][j] = (dp[i-1][j-1] % mod + dp[i-1][j+1] % mod) % mod;
            }
        }
        
        int ans = 0;
        for(int i=1; i<=9; i++) {
            ans += dp[n][i];
            ans %= mod;
        }
        
        System.out.print(ans);
    }
    
}

