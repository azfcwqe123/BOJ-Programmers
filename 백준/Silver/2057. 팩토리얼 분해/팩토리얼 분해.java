import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        long n = Long.parseLong(br.readLine());
        long[] arr = new long[20];
        
        if(n == 0) {
            System.out.print("NO");
            System.exit(0);
        }
        
        arr[0] = 1L;
        
        for(int i=1; i<=19; i++) arr[i] = arr[i-1] * i;
        
        for(int i=19; i>=0; i--) {
            if(n >= arr[i]) n -= arr[i];
            
            if(n == 0) {
                System.out.print("YES");
                System.exit(0);
            }
        }
        
        System.out.print("NO");
    }
    
}
