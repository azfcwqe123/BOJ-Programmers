import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        
        int max = 0, cnt = 0;
        
        for(int i=x; i<=n; i++) max = Math.max(max, sum[i] - sum[i-x]);
        
        for(int i=x; i<=n; i++) {
            int tmp = sum[i] - sum[i-x];
            if(tmp == max) cnt++;
        }
        
        
        if(max == 0) System.out.print("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);    
        }
        
    }
    
}

