import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            dp[i] = i;
            for(int j=1; j*j<=i; j++) {
                if(dp[i] > dp[i - j * j] + 1) dp[i] = dp[i - j * j] + 1;
            }
        }
        
        System.out.print(dp[n]);
    }
    
}

