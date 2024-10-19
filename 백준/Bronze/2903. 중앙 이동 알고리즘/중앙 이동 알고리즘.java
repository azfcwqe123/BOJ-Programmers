import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int sum = 2;
	    
	    for(int i=1; i<=n; i++) {
	        sum += (int) Math.pow(2,i-1);
	    }
	    
	    System.out.print(sum*sum);
	}
	    
}
	


