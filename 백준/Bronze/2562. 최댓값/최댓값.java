import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int max = Integer.MIN_VALUE;
	    int m = 0;
	    
	    for(int i=0; i<9; i++) {
	        int n = Integer.parseInt(br.readLine());
	        
	        if(max < n) {
	            max = n;
	            m = i;
	        }    
	    }
	    
	    System.out.println(max);
	    System.out.println(m+1);
	    
	}
}   

