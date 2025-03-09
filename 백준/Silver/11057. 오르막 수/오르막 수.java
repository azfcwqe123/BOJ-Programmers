import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int mod = 10007;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        // row는 자리수, column은 시작수
        int[][] dp = new int[n+1][10];
        
        for(int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=2; i<=n; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=j; k<=9; k++) dp[i][j] += dp[i-1][k] % mod;
            }
        }   
        
        int ans = 0;
        for(int i=0; i<=9; i++) {
            ans += dp[n][i];
            ans %= mod;
        }
        
        System.out.print(ans);
        
    }
}
