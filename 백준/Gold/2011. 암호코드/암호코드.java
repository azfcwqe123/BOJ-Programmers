import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int mod = 1000000;
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        int len = str.length();
        
        if(str.charAt(0) == '0') {
            System.out.print(0);
            System.exit(0);
        }
        
        int[] dp = new int[len + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=len; i++) {
            int check = Integer.parseInt(str.substring(i-2, i));
            
            if(str.charAt(i-1) != '0') dp[i] += dp[i-1] % mod;
            if(check >= 10 && check <= 26) dp[i] += dp[i-2] % mod;
        }
        
        System.out.print(dp[len] % mod);
        
    }
    
}

