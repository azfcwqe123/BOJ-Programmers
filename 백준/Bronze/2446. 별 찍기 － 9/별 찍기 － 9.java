import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=1; i<n; i++) {
	        
	        for(int j=1; j<i; j++) {
	            sb.append(" ");
	        }
	        
	        for(int k=0; k<2*n-1-2*(i-1); k++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	    }
	    
	    sb.append(" ".repeat(n-1) + "*").append("\n");
	    
	    for(int i=1; i<n; i++) {
	        
	        for(int j=i; j<n-1; j++) {
	            sb.append(" ");
	        }
	        
	        for(int k=1; k<i*2+2; k++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}



