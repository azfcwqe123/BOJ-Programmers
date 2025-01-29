import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        long ans = 0;
        
        for(int i=0; i<n; i++) {
            ans += Math.abs(arr[i] - (i + 1));
        }
        
        System.out.print(ans);
        
    }
}

