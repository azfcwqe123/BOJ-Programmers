import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int[] chess = {1, 1, 2, 2, 2, 8};
	    
	    for(int i=0; i<6; i++) {
	        System.out.print(chess[i] - Integer.parseInt(st.nextToken()) + " ");
	    }
	    
	}
	
}   


