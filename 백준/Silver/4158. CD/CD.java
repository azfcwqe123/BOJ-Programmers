import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            
            for(int i=0; i<n; i++) arr1[i] = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++) arr2[i] = Integer.parseInt(br.readLine());
            
            int lt = 0, rt = 0;
            
            int ans = 0;
            
            while(lt < n && rt < m) {
                
                if(arr1[lt] == arr2[rt]) {
                    ans++;
                    lt++;
                    rt++;
                }
                
                else if(arr1[lt] < arr2[rt]) lt++;
                
                else if(arr1[lt] > arr2[rt]) rt++;
                
            }
            
            System.out.println(ans);
            
        }
        
        
    }
    
}

