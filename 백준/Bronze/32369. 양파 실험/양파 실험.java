import java.io.*;
import java.util.*;

class Main {
    
    static int sum = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    
	    int happyOnion = 1, badOnion = 1;
	    
	    
	    while(n-- > 0) {
	        
	        happyOnion += a;
	        badOnion += b;
	        
	        if(badOnion > happyOnion) {
	            int tmp = happyOnion;
	            happyOnion = badOnion;
	            badOnion = tmp;
	        }
	        
	        else if(badOnion == happyOnion) badOnion -= 1;
	    }
	    
	    System.out.print(happyOnion + " " + badOnion);
	    
	}
	
}
