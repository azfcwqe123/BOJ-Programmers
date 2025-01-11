import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] books = new int[n];
        
        int ans = (n == 0 ? 0 : 1), sum = 0;
        
        if(n > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) books[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int x : books) {
            sum += x;
            
            if(sum > w) {
                sum = x;
                ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
}
