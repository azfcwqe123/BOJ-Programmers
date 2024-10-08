import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int X = Integer.parseInt(br.readLine());
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int sum = 0;
	    
	    while(n-- > 0) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        sum += a*b;    
	    }
	    
	    if(sum == X) System.out.print("Yes");
	    else System.out.print("No");
	    
	}
}   

