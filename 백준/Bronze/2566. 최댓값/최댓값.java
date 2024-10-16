import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int max = Integer.MIN_VALUE;
	    
	    int column = 0, row =0;
	    
	    for(int i=0; i<9; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j=0; j<9; j++) {
	            int n = Integer.parseInt(st.nextToken());
	            
	            if(n > max) {
	                max = n;
	                row = i;
	                column = j;
	            }        
	            
	        }
	    }
	    
	    System.out.println(max);
	    System.out.print((row+1) + " " + (column+1));
	        
	}
	    
}
	


