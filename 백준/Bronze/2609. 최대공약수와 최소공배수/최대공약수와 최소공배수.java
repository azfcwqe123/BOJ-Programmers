import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int K = gcd(a, b);
        
        int m = a / K;
        
        System.out.println(K);
        System.out.println(m * b);
        
    }
    
    private static int gcd(int n, int m) {
        if(m == 0) return n;
        else return gcd(m, n % m);
    }
    
}

