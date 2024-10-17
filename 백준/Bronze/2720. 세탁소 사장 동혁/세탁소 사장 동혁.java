import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int T = Integer.parseInt(br.readLine());
	        
	    StringBuilder sb = new StringBuilder();
	    
	    while(T-->0) {
	        
	        int C = Integer.parseInt(br.readLine());
	        
	        sb.append(C/25 + " ");
	        C %= 25;
	        
	        sb.append(C/10+ " ");
	        C %= 10;
	        
	        sb.append(C/5 + " ");
	        C %= 5;
	        
	        sb.append(C/1 + "\n");
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}
	


