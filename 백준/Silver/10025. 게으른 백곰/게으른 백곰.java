import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int[] pos = new int[1_000_001];
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
 	    
 	    while(n-- > 0) {
 	        st = new StringTokenizer(br.readLine());
 	        
 	        int g = Integer.parseInt(st.nextToken());
 	        int x = Integer.parseInt(st.nextToken());
 	        
 	        pos[x] = g;
 	    }
 	    
 	    int sum = 0, max = -1;
 	    
 	    int d = 2*k + 1;
 	    
 	    for(int i=0; i<=1_000_000; i++) {
 	        sum += pos[i];
 	        
 	        if(i >= d) sum -= pos[i-d];
 	        
 	        max = Math.max(sum, max);
 	    }
 	    
 	    System.out.print(max);
    }

}