import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=n-i-1; j>=1; j--) {
	            sb.append(" ");
	        }
	        
	        for(int k=0; k<i*2+1; k++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	    }
	    
	    for(int i=0; i<n*2-1; i++) {
	        sb.append("*");
	    }
	    sb.append("\n");
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=0; j<=i; j++) {
	            sb.append(" ");
	        }
	        
	        for(int k=0; k<2*(n-1)-1 -i*2; k++) {
	            sb.append("*");
	        }
	        sb.append("\n");
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	
}   


