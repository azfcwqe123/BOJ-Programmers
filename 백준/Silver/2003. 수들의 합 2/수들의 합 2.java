import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    int lt=0, rt = 0;
	    
	    int ans = 0, sum = 0;
	    
	    while(rt < n) {
	        
	        sum += arr[rt++];
	        
	        if(sum == m) ans++; 
	           
	        while(sum >= m) {
	            sum -= arr[lt++];
	            if(sum == m) ans++;
	        }
	    }
	    
	    
	    System.out.print(ans);

	    
    }
    
}