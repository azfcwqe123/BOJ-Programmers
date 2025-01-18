import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        
        int ans = 0;
        for(int i=arr.length-1; i>=0; i--) {
            ans += k / arr[i];
            k %= arr[i];
            
            if(k == 0) break;
        }
        
        System.out.print(ans);
        
    }
    
}

