import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    
	    for(int i=0; i<n-1; i++) {
	        sb.append(" ".repeat(n-1-i));
	        sb.append("*".repeat(2*i+1));
	        sb.append("\n");
	    }
	    
	    sb.append("*".repeat(2*n-1)).append("\n");
	    
	    for(int i=0; i<n-1; i++) {
	        sb.append(" ".repeat(i+1));
	        sb.append("*".repeat(2*(n-1)-1-2*i));
	        sb.append("\n");
	    }
	    
	    System.out.print(sb);
	    
	}
	
}   


