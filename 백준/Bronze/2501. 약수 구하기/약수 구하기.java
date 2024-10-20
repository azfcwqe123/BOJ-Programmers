import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    int tmp = 0;
	    int cnt = 0;
	    
	    for(int i=N; i>=1; i--) {
	        
	        if(N % i == 0) {
	            tmp = N / i;
	            cnt++;
	            
	            if(cnt == K) {
	                System.out.print(tmp);
	                return;
	            }
	        }
	        
	    }
	    
	    if(cnt < K) {
	        System.out.print(0);
	    }
 	    
	}
	    
}
	


