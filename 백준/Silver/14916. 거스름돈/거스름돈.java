import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        
        while(true) {
            
            if(n % 5 == 0) {
                cnt += n / 5;
                System.out.print(cnt);
                break;
            }
            
            else {
                n -= 2;
                cnt++;
            }
            
            if(n < 0) {
                System.out.print(-1);
                break;
            }
            
        }
        
        
    }
    
}

