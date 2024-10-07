import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int h = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int a = (m + n) / 60;
	    
	    if(a > 0) {
	        if(h + a > 23) h = (h + a) - 24;
	        else h += a;
	        m = (m + n) % 60;
	    } else {
	        m += n;
	    }
	    
	    System.out.print(h + " " + m);
	    
	}
}   

