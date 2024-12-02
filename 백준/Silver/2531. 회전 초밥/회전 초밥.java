import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int d = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n + k - 1];
	    
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	    
	    for(int i=n; i<n+k-1; i++) {
	        arr[i] = arr[i-n];
	    }
	    
	    boolean[] fish = new boolean[d+1];
        
        int lt=0, rt = k-1;
        
        int ans = 0;
        
        while(rt < n+k-1) {
            
            fish[c] = true;
            int cnt = 0;
            
            for(int i = lt; i <= rt; i++) fish[arr[i]] = true;
           
            
            for(int i = 1; i <= d; i++) if(fish[i] == true) cnt++;
            
            Arrays.fill(fish, false);
            
            ans = Math.max(ans, cnt);
            
            lt++;
            rt++;
            
        }
        
        System.out.print(ans);
	    
    }
    
}