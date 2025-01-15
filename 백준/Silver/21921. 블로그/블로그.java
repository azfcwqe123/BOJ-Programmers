import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0, sum = 0, ans = 1;
        
        for(int i=0; i<x; i++) sum += arr[i];
        
        max = sum;
        
        for(int i=x; i<arr.length; i++) {
            
            sum += arr[i] - arr[i-x];
            
            if(sum > max) {
                max = sum;
                ans = 1;
            }
            
            else if(sum == max) ans++;
            
        }
        
        if(max == 0) System.out.print("SAD");
        else {
            System.out.println(max);
            System.out.println(ans);    
        }
        
    }
    
}

