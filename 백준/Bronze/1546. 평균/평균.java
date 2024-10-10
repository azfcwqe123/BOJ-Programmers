import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] arr = new int[n];
	    
	    int max = -1;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	        
	        max = Math.max(max, arr[i]);
	    }
	    
	    double ans = 0;
	    
	    for(int i=0; i<n; i++) {
	        ans += (double) arr[i] / max * 100;    
	    }
	    
	    System.out.print(ans / n);
        
	}
	
}   


