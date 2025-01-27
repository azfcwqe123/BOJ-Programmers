import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr, (a, b) -> b - a);
        
        int ans = -1;
        
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, arr[i] + i + 1);
        }
        
        System.out.print(ans + 1);
    }
    
}
