import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        
        int ans = 0;
        int start = 1, end = m;
        
        while(j-- > 0) {
            int apple = Integer.parseInt(br.readLine());
            
            if(end < apple) {
                int move = apple - end;
                ans += move;
                start += move;
                end = apple;
            }
            
            else if(apple < start) {
                int move = start - apple;
                ans += move;
                start = apple;
                end -= move;
            }
            
        }
        
        System.out.print(ans);
    }
    
}
