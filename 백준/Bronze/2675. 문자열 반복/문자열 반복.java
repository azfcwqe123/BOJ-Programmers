import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(n-- > 0) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int k = Integer.parseInt(st.nextToken());
	        String str = st.nextToken();
	        
	        for(int i=0; i<str.length(); i++) {
	            sb.append(String.valueOf(str.charAt(i)).repeat(k));
	        }
	        
	        sb.append("\n");
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	
}   


