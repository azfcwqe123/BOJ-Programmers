import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    while(true) {
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        if(n == -1) {
	            break;
	        }
	        
	        int sum = 0;
	        int cnt = 0;
	        
	        StringBuilder sb = new StringBuilder();

	        for(int i=1; i<n; i++) {
	            if(n % i == 0) {
	                sum += i;    
	                cnt++;
	            }
	        }
	        
	        
	        if(sum == n) {
	            
	            sb.append(n + " = ");
	            for(int i=1; i<n; i++) {
	                
	                if(n % i == 0 && cnt > 1) {
	                    sb.append(i + " + ");
	                    cnt--;
	                } else if(n % i == 0 && cnt == 1) {
	                    sb.append(i);
	                }
	                
	            }
	        } else {
	            sb.append(n + " is NOT perfect.");
	        }
            
            System.out.println(sb);
	        
	    }
 	    
	}
	    
}
	


