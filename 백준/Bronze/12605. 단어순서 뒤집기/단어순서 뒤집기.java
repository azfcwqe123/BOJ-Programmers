import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<String> stack = new Stack<>();
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=1; i<=n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        while(st.hasMoreTokens()) stack.push(st.nextToken());
	        
	        sb.append("Case #").append(i).append(": ");
	        while(!stack.isEmpty()) {
	           sb.append(stack.pop() + " ");
	        }
	        sb.append('\n');
	    }
	    
	    System.out.print(sb);
    }

}