import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        long n = Long.parseLong(br.readLine());
        
        long sum = 0, ans = 0;
        
        for(int i=1; ; i++) {
            sum += i;
            ans++;
            if(sum > n) {
                System.out.print(ans - 1);
                return;
            }
        }
        
    }
    
}

