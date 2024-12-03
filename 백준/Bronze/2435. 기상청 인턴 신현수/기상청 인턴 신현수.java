import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());    
	    }
	    
	    int sum = 0, max = Integer.MIN_VALUE;
	    
	    for(int i=0; i<n; i++) {
	        sum += arr[i];
	        
	        if(i == k-1) {
	            max = sum;
	        }
	        
	        if(i >= k) {
	            sum -= arr[i-k];
	            max = Math.max(max, sum);
	        }
	        
	    }
	    
	    System.out.print(max);
 	    
    }

}