import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    int cnt = 1;
	    
	    while(true) {
	        
	        int fx = 3*(int) Math.pow(cnt,2) - 3*cnt + 1;
	        
	        if(N <= fx) {
	            System.out.print(cnt);
	            return;
	        } else cnt++;
	        
	    }
	    
	}
	    
}
	


