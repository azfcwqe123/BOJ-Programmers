import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<Character> stack = new Stack<>();
	    
	    int ans = 0;
	    
	    while(n-- > 0) {
	        
	        for(char x : br.readLine().toCharArray()) {
	            
	            if(stack.isEmpty()) stack.push(x);
	            else if(stack.peek() == x) stack.pop();
	            else stack.push(x);
	            
	        }
	        
	        if(stack.isEmpty()) ans++;
	        else while(!stack.isEmpty()) stack.pop();
	        
	    }
	    
        System.out.print(ans);
	    
    }

}