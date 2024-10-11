import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(n-- > 0) {
	        String str = br.readLine();
	            
	        sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
	    }
	    
	    System.out.print(sb);
	}
	
}   


