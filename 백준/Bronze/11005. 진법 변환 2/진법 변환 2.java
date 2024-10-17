import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(N > 0) {
	       
	       if(N % B < 10) {
	           sb.append((char) (N % B + '0'));
	       } else {
	           sb.append((char) ((N % B)-10 + 'A'));
	       }
	       
	       N /= B;
	    } 
	    
	    System.out.println(sb.reverse());
	}
	    
}
	


