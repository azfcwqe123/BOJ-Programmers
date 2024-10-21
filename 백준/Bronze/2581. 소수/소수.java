import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int M = Integer.parseInt(br.readLine());
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    int sum = 0;
	    
	    for(int i=M; i<=N; i++) {
	        
	        int cnt = 0;
	        for(int j=2; j<=i; j++) {
	            if(i % j == 0) cnt++;
	        }
	        
	        if(cnt == 1) sum += i;
	    }
	    
	    if(sum == 0) {
	        System.out.print(-1);
	        return;
	    }
	    else System.out.println(sum);
	    
	    
	    for(int i=M; i<=N; i++) {
	        
	        int cnt = 0;
	        for(int j=2; j<=i; j++) {
	            if(i % j == 0) cnt++;
	        }
	        
	        if(cnt == 1) {
	            System.out.print(i);
	            return;
	        }
	            
	    }
	    
	    
	}
	    
}
	


