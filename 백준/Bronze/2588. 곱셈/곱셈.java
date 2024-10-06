import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int a = Integer.parseInt(br.readLine());
	    int b = Integer.parseInt(br.readLine());
	    
	    int c = a * (b%10);
	    int d = a * ((b/10) % 10);
	    int e = a * (b/100);
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append(c).append('\n').append(d).append('\n').append(e).append('\n').append(c+d*10+e*100);
	    
	    System.out.println(sb);
	    
	    
	    
	    
	    
	}
}   

