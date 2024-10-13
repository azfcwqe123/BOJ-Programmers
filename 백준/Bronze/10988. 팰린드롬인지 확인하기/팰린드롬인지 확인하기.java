import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str1 = br.readLine();
	    
	    String str2 = new StringBuilder(str1).reverse().toString();
	    
	    if(str1.equals(str2)) System.out.print(1);
	    else System.out.print(0);
	    
	}
	
}   


