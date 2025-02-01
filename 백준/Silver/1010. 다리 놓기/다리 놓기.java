import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[30][30];
    
    public static void main(String[] args) throws IOException {
        
        for(int i=0; i<30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        
        for(int i=2; i<30; i++) {
            for(int j=1; j<30; j++) {
                
                if(j-1 > i-1 || j > i-1) continue;
                
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            sb.append(dp[n][r]).append("\n");
        }
        
        System.out.print(sb);
        
    }
}

