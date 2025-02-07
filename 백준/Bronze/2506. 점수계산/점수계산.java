import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int ans = 0, cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        
        while(st.hasMoreTokens()) {
            int k = Integer.parseInt(st.nextToken());
            
            if(k == 0) cnt = 0;
            else ans += ++cnt;
        }
        
        System.out.print(ans);
    }
    
}

