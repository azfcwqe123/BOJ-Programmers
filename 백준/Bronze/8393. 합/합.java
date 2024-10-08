import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine()) + 1;
	    
	    int sum = 0;
	    
	    while(n-- > 0) sum += n;
	
	    System.out.print(sum);
	    
	}
}   

