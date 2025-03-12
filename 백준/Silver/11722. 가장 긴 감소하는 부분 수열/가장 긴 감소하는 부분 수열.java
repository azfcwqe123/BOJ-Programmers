import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.fill(dp, 1);
        
        int max = 1;
        
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(arr[i] < arr[j] && dp[i] < dp[j] + 1) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        
        System.out.print(max);
    }
    
}

