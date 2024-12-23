import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int a=0, b=0, c=0;
        
        if(n / 300 > 0) {
            a = n / 300;
            n -= 300 * a;
        }
        
        if(n / 60 > 0) {
            b = n / 60;
            n -= 60 * b;
        }
        
        if(n / 10 > 0) {
            c = n / 10;
            n -= 10 * c;
        }
        
        if(n > 0) System.out.print(-1);
        else System.out.print(a + " " + b + " " + c); 
    }
    
}

