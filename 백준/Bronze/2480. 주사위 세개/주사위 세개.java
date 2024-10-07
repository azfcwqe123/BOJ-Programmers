import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    
	    int res = 0;
	    
	    if(a == b && b == c) {
	        res += 10000 + a*1000;    
	    }
	    else if(a == b || b == c || c == a) {
	        if(a==b) res += 1000 + a*100;
	        else if(b == c) res += 1000 + b*100;
	        else if(c == a) res += 1000 + c*100;
	    } else {
	        res += Math.max(a,Math.max(b,c))*100;
	    }
	    
	    System.out.print(res);
	
	    
	}
}   

