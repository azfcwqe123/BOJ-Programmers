import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] card = new int[n+1];
        int[] dp = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) card[i] = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
            } 
        }
        
        System.out.print(dp[n]);
    }
    
}

