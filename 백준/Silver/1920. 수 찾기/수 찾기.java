import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            
            if(Arrays.binarySearch(arr, k) >= 0) sb.append(1);
            else sb.append(0);
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
        
}

