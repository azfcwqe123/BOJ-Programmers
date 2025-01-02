import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        long sum = 0;
        
        String str = br.readLine();
        
        for(int i=0; i<n; i++) {
            sum += (long) (Math.pow(31, i) * (str.charAt(i) - 96));
        }
        
        System.out.print(sum);
    }
    
}

