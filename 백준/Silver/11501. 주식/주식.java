import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
            
            long ans = 0, max = 0;
            
            for(int j=arr.length-1; j>=0; j--) {
                if(max < arr[j]) max = arr[j];
                else ans += max - arr[j];
            }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}
