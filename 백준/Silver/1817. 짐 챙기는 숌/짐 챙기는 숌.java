import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        if(n == 0) {
            System.out.print(0);
            System.exit(0);
        }
        
        int ans = 0, sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            if(sum + arr[i] == m) {
                ans++;
                sum = 0;
            }
            
            else if(sum + arr[i] > m) {
                sum = 0;
                sum += arr[i];
                ans++;
            }
            
            else {
                sum += arr[i];
            }
                
        }
        
        if(sum > 0) ans++;
        
        System.out.print(ans);
        
        
    }
    
}
