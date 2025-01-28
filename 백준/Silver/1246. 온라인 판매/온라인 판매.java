import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] P = new int[m];
        
        for(int i=0; i<m; i++) P[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(P);
        
        int ans = Integer.MIN_VALUE, idx = 0, tmp = 0;
        
        for(int i=0; i<m; i++) {
            int k = m - i;
            
            if(k <= n) tmp = P[i] * k;
            else tmp = P[i] * n;
            
            if(tmp > ans) {
                ans = tmp;
                idx = i;
            }
        }
        
        System.out.print(P[idx] + " " + ans);
    }
}

