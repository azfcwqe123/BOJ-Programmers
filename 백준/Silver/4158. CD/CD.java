import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            int ans = 0;
            HashSet<Integer> set = new HashSet<>();
            
            while(n-- > 0) set.add(Integer.parseInt(br.readLine()));
        
            while(m-- > 0) {
                int k = Integer.parseInt(br.readLine());
                if(set.contains(k)) ans++;
                else set.add(k);
            }
            
            System.out.println(ans);
            
        }
        
        
    }
    
}

