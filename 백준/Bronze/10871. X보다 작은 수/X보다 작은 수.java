import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int X = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(st.hasMoreTokens()) {
	        int a = Integer.parseInt(st.nextToken());
	        if(a < X) sb.append(a + " ");
	    }
	    
	    System.out.print(sb);
	    
	}
}   

