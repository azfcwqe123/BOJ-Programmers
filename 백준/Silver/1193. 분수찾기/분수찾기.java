import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int X = Integer.parseInt(br.readLine());
	    
	    int n = 1;
 	    
 	    while(X > n*(n+1)/2) {
 	        n++;
 	    }
 	    
 	    int top, bot;
        
        int current = n*(n-1)/2 + 1;
        
        if(n%2==0) {
            top=1; 
            bot=n;
            
            while(current != X) {
                top++;
                bot--;
                current++;
            }
            
            System.out.print(top + "/" + bot);
            
        } else {
            top=n;
            bot=1;
            
            while(current != X) {
                top--;
                bot++;
                current++;
            }
            
            System.out.print(top + "/" + bot);
        }
 	    
	}
	    
}
	


