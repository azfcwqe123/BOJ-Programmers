import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[30][30];
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            sb.append(combi(n, r)).append("\n");
        }
        
        System.out.print(sb);
        
    }
    
    static int combi(int n, int r) {
        
        if(dp[n][r] > 0) return dp[n][r];
        
        if(n == r || r == 0) return dp[n][r] = 1;
        
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
    
}

