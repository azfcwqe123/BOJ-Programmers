import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    long n = Integer.parseInt(br.readLine());
	    System.out.println(n*(n-1)/2);
	    System.out.print(2);
	    
	}
}

