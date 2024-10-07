import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    if(n >= 90) System.out.print("A");
	    else if(n >= 80) System.out.print("B");
	    else if(n >= 70) System.out.print("C");
	    else if(n >= 60) System.out.print("D");
	    else System.out.print("F");
	    
	}
}   

