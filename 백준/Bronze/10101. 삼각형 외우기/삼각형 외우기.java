import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int a = Integer.parseInt(br.readLine());
	    int b = Integer.parseInt(br.readLine());
	    int c = Integer.parseInt(br.readLine());
	    
	    
	    if(a + b + c != 180) System.out.print("Error");
	    else {
	        if(a==b && b==c) System.out.print("Equilateral");
	        
	        else if(a==b || b==c || c==a) System.out.print("Isosceles");
	        
	        else System.out.print("Scalene");
	    }
	}
}



