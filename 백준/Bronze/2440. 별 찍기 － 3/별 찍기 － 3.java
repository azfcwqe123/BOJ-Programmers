import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<n; i++) {
	            
	       for(int j=i; j<n; j++) {
	           sb.append("*");
	       }     
	       sb.append('\n');
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}
	


