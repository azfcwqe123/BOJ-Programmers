import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
	    int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
	    
	    System.out.print(a>b ? a : b);
	    
	}
	
}   


