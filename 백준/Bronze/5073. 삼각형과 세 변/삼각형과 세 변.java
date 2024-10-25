import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    while(true) {
	        
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        
	        if(a==0 && b==0 && c==0) return;
	        
	        if(a + b > c && a + c > b && b + c > a) {
	            if(a==b && b==c) System.out.println("Equilateral");
	            else if(a==b || b==c || c==a) System.out.println("Isosceles");
	            else System.out.println("Scalene");    
	        } else {
	            System.out.println("Invalid");
	        }
	        
	    }
	    
	    
	}
}



