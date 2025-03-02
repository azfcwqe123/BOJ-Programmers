import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        hanoi(1, 3, n);
        System.out.println((1<<n) - 1);
        System.out.println(sb);
    }
    
    static void hanoi(int a, int b, int n) {
        
        if(n==1) {
            sb.append(a + " " + b).append('\n');
            return;
        }
        
        hanoi(a, 6-a-b, n-1);
        sb.append(a + " " + b).append('\n');
        hanoi(6-a-b, b, n-1);
    }
}