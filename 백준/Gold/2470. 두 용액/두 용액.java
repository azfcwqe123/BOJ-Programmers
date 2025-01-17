import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int lt = 0;
        int rt = arr.length - 1;
        
        int min = Integer.MAX_VALUE;
        
        int[] ans = new int[2];
        
        while(lt < rt) {
            
            int a = arr[lt];
            int b = arr[rt];
            
            int diff = Math.abs(a + b);
            
            if(diff < min) {
                ans[0] = arr[lt];
                ans[1] = arr[rt];
                min = diff;
            }
            
            if(a + b > 0) rt--;
            else lt++;
        }
        
        for(int x : ans) System.out.print(x + " ");
    }
    
}

