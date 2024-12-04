import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<String> stack = new Stack<>();
	    
	    for(int i=1; i<=n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        while(st.hasMoreTokens()) stack.push(st.nextToken());
	        
	        System.out.print("Case #" + i + ": ");
	        while(!stack.isEmpty()) {
	           System.out.print(stack.pop() + " ");
	        }
	        System.out.println();
	    }
	    
    }

}