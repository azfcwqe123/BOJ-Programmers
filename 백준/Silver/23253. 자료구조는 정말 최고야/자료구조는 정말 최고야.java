import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<m; i++) {
            
            int prevB = 200_001;
            
            int k = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<k; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur > prevB) {
                    System.out.print("No");
                    return;
                }
                prevB = cur;
            }
        }
        
        System.out.print("Yes");
        
    }
    
}

