import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int x = Integer.parseInt(st.nextToken());
	    int y = Integer.parseInt(st.nextToken());
	    int w = Integer.parseInt(st.nextToken());
	    int h = Integer.parseInt(st.nextToken());
	    
	    int max = Math.min(x,Math.min(y,Math.min(w-x,h-y)));
	    
	    System.out.print(max);
	    
	}
}



