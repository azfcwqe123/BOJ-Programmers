import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++) {
            int num = i;
            int sum = 0;
            
            sum += num;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            
            if(sum == n) {
                System.out.print(i);
                return;
            }
        }
        
        System.out.print(0);

    }
    
}
    


