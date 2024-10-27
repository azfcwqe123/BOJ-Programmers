import java.io.*;
import java.util.*;

class Main {
    
    static int sum = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st;
	    
	    for(int i=0; i<8; i++) {
	        st = new StringTokenizer(br.readLine());    
	        
	        String str = st.nextToken();
	        
	        for(int j=0; j<8; j++) {
	            char ch = str.charAt(j);   
	                
	            check(ch);
	        }
	        
	    }
	    
	    System.out.print(sum);
	    
	}
	
	static void check(char ch) {
	    
	    if(ch == 'k') sum -= 0;
	    else if(ch == 'p') sum -= 1;
	    else if(ch == 'n') sum -= 3;
	    else if(ch == 'b') sum -= 3;
	    else if(ch == 'r') sum -= 5;
	    else if(ch == 'q') sum -= 9;
	    else if(ch == 'K') sum += 0;
	    else if(ch == 'P') sum += 1;
	    else if(ch == 'N') sum += 3;
	    else if(ch == 'B') sum += 3;
	    else if(ch == 'R') sum += 5;
	    else if(ch == 'Q') sum += 9;
	    
	}
	
}
