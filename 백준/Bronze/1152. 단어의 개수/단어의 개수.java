import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine().trim();
	    
	    if(str.length() == 0) System.out.print(0);
	    else System.out.print(str.split(" ").length);
	    
	    
	}
	
}   


