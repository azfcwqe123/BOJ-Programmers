import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int x = Integer.parseInt(br.readLine());
	    int y = Integer.parseInt(br.readLine());
	    
	    int res = x > 0 ? (y > 0 ? 1 : 4) : (y > 0 ? 2 : 3);
	    
	    System.out.print(res);

	    
	}
}   

