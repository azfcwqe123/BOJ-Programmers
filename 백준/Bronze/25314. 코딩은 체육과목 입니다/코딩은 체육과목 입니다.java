import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine()) / 4;
	    
	    StringBuilder sb = new StringBuilder();
	    while(n-- > 0) {
	        sb.append("long ");
	    }
	    
	    sb.append("int");
	    
	    System.out.print(sb);
	    
	}
}   

