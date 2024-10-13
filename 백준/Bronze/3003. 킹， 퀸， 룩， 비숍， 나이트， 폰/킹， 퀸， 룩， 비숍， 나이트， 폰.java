import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int a = 1 - Integer.parseInt(st.nextToken());
	    int b = 1 - Integer.parseInt(st.nextToken());
	    int c = 2 - Integer.parseInt(st.nextToken());
	    int d = 2 - Integer.parseInt(st.nextToken());
	    int e = 2 - Integer.parseInt(st.nextToken());
	    int f = 8 - Integer.parseInt(st.nextToken());
	    
	    System.out.print(a + " " + b + " " + c + " " + d + " " + e + " " + f);
	    

	}
	
}   


