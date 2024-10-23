import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=0; j<i+1; j++) {
	            sb.append("*");
	        }
	        
	        for(int k=0; k<(n-1)*2-2*i; k++) {
	            sb.append(" ");
	        }	        
	        
	        for(int j=0; j<i+1; j++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	    }
	    
	    sb.append("*".repeat(n*2));
	    
	    sb.append("\n");
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=i; j<n-1; j++) {
	            sb.append("*");
	        }
	        
	        for(int k=0; k< 2*(i+1); k++) {
	            sb.append(" ");
	        }
	        
	        for(int j=i; j<n-1; j++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}



