import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] A = new int[n];
        int[] B = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) B[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ans = 0;
        
        for(int i=B.length-1; i>=0; i--) {
            ans += B[i] * A[n-i-1];
        }
        
        System.out.print(ans);
        
    }
}


