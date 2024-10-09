import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int cnt = 0;
	    int n = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    
	    while(st.hasMoreTokens()) {
	        if(Integer.parseInt(st.nextToken()) == m) cnt++;
	    }
	    
	    System.out.print(cnt);
	    
	}
}   

