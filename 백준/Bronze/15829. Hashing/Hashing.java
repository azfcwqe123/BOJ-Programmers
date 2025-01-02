import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static final int m = 1_234_567_891;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        long sum = 0;
        
        String str = br.readLine();
        
        long pow = 1;
        
        for(int i=0; i<n; i++) {
            int alphabet = (int) (str.charAt(i) - 96);
            sum += alphabet * pow % m;
            pow = (pow * 31) % m;
        }
        
        System.out.print(sum % m);
    }
    
}

