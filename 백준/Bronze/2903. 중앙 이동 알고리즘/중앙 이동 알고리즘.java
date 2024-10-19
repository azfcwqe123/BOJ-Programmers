import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int ans = (int) Math.pow((Math.pow(2,n) + 1),2);
	    
	    System.out.print(ans);
	}
	    
}
	


