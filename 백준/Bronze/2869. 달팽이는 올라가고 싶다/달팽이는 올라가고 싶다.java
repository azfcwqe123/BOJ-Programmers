import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    int V = Integer.parseInt(st.nextToken());
	    
	    int ans = (V-A)/(A-B);
	    
	    if((V-A)%(A-B) == 0) {
	        ans++;
	    } else ans+=2;
	    
	    System.out.print(ans);
 	    
	}
	    
}
	


