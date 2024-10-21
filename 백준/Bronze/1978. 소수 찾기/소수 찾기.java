import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int ans = 0;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    while(n-- > 0) {
	        int k = Integer.parseInt(st.nextToken());
	        
	        int cnt = 0;
	        
	        for(int i=2; i<=k; i++) {
	            
	            if(k % i == 0) cnt++;
	        }
	        
	        if(cnt == 1) ans++;
	        
	    }
	    
	    System.out.print(ans);
	    
	}
	    
}
	


