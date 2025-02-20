import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        boolean[] arr = new boolean[10100];
        
        for(int i=1; i<10000; i++) {
            arr[check(i)] = true;
            if(!arr[i]) sb.append(i).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int check(int n) {
        int sum = n;
        
        while(n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        
        return sum;
    }
    
}

