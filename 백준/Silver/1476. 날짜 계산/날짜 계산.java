import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int e = 1, s = 1, m = 1, ans = 1;
        
        while(true) {
        
            if(e == E && s == S && m == M) {
                System.out.println(ans);
                return;
            }   
            
            e++;
            s++;
            m++;
            
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
            
            ans++;
        }
        
    }
}


