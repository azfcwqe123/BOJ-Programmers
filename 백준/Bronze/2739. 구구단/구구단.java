import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    for(int i=0; i<9; i++) {
	        System.out.println(n + " * " + (i+1) + " = "+ n*(i+1));
	    }
	
	    
	}
}   

