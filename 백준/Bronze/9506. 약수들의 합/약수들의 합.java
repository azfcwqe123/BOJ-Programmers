import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    while(true) {
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        if(n == -1) break;
	        
	        int sum = 0;
	        
	        for(int i=1; i<n; i++) {
	            if(n % i == 0) sum += i;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        if(sum == n) {
	            sb.append(n + " = 1 ");
	            
	            for(int i=2; i<n; i++) {
	                if(n % i == 0) sb.append("+ " + i + " ");
	            }
	            
	        } else sb.append(n + " is NOT perfect.");
	        
	        
	        System.out.println(sb);
	
	        
	    }
 	    
	}
	    
}
	


