import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr, (a, b) -> b - a);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            max = Math.max(max, arr[i] *(i+1));
        }
        
        System.out.print(max);
    }
    
}

