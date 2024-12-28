import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int k = (int) Math.round(n * 0.15);
        
        double sum = 0;
        
        for(int i=k; i<n-k; i++) {
            sum += arr[i];
        }
        
        int ans = (int) Math.round(sum / (n - k*2));
        System.out.print(ans);
        
    }
    
}
    


