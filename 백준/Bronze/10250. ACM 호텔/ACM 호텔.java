import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            
            if(N % H == 0) System.out.println(H * 100 + (N / H));
            else System.out.println((N % H) * 100 + (N / H) + 1);
            
        }
        
    }
        
}

