import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int max = 1_000_000;
    static int[] arr = new int[2 * max + 1];
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k + max]++;
        }
        
        for(int i=0; i<=2*max; i++) {
            if(arr[i] == 0) continue;
            else run(i);
        }
        
        System.out.print(sb);
    }
    
    static void run(int i) {
        while(arr[i] > 0) {
            sb.append(i - max).append('\n');
            arr[i]--;
        }
    }
}

