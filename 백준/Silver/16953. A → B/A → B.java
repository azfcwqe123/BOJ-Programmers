import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int cnt = 0;
        
        while(A < B) {
            if(B % 2 == 0) {
                B /= 2;
                cnt++;
            }
            
            else if(B % 10 == 1) {
                B /= 10;
                cnt++;
            }
            
            else break;
        }
        
        if(A == B) System.out.print(cnt + 1);
        else System.out.print(-1);
        
    }
    
}

