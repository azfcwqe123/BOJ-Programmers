import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        int ans = Math.abs(A - B);
        
        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            ans = Math.min(ans, Math.abs(tmp - B) + 1);
        }
        
        System.out.println(ans);
    }
    
}

