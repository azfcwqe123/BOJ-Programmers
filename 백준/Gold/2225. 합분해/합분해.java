import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[k+1][n+1];
        
        Arrays.fill(dp[1], 1);
        
        for(int i=2; i<=k; i++) {
            dp[i][0] = 1;
            for(int j=1; j<=n; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
            }
        }
        
        System.out.print(dp[k][n]);
    }
    
}

