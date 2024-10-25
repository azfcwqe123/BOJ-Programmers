import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int[] P = new int[3];
	    
	    P[0] = Integer.parseInt(st.nextToken());
	    P[1] = Integer.parseInt(st.nextToken());
	    P[2] = Integer.parseInt(st.nextToken());
	    
	    Arrays.sort(P);
	    
	    if(P[2] >= P[0] + P[1]) P[2] = (P[0] + P[1]) -1;
	    
	    System.out.print(P[0] + P[1] + P[2]);
	    
	}
}



