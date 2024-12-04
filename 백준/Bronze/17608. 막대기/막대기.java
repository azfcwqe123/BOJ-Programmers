import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    while(n-- > 0) {
	        
	        int tmp = Integer.parseInt(br.readLine());
	        
	        while(!stack.isEmpty() && stack.peek() <= tmp) stack.pop();    
	        
	        stack.push(tmp);
	    }
	    
	    System.out.print(stack.size());
	    
    }

}