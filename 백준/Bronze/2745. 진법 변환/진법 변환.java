import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    String N = st.nextToken();
	    int B = Integer.parseInt(st.nextToken());
	    int exponent = 0;
	    int res = 0;
	    
	    for(int i=N.length()-1; i>=0; i--) {
	        char ch = N.charAt(i);
	        int k = 0;
	        
	        if(ch >= '0' && ch <= '9') {
	            k = ch - '0';
	        } else {
	            k = ch - 55;
	        }
	        
	        res += k * Math.pow(B,exponent++);
	    }
	    
	    System.out.print(res);
	    
	    
	}
	    
}
	


