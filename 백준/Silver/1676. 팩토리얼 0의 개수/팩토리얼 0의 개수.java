import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        while(n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        
        System.out.print(ans);
    }
        
}

