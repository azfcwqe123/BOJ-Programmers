import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int maxX=-100001, minX=100001, maxY=-100001, minY=100001;
	    
	    while(n-- > 0) {
	       
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       
	       int x = Integer.parseInt(st.nextToken());
	       int y = Integer.parseInt(st.nextToken());
	       
	       maxX = Math.max(maxX,x);
	       minX = Math.min(minX,x);
	       
	       maxY = Math.max(maxY,y);
	       minY = Math.min(minY,y);
	    }
	    
	    int square = (maxX - minX) * (maxY - minY);
	    
	    System.out.print(square);
	    
	}
}



