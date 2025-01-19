import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        long[] dis = new long[n-1];
        long[] cost = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) dis[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) cost[i] = Integer.parseInt(st.nextToken());
        
        long ans = 0;
        long minCost = cost[0];
        
        for(int i=0; i<n-1; i++) {
            
            if(minCost > cost[i]) minCost = cost[i];
            
            ans += minCost * dis[i];
        }
        
        System.out.print(ans);
        
    }
    
}

