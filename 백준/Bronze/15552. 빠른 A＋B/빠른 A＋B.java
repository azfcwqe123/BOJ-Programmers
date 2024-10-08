import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    while(n-- > 0) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        sb.append(a+b).append("\n");
	    }
	    
	    System.out.print(sb);
	    
	}
}   

