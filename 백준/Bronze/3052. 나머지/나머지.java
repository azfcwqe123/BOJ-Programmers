import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    boolean[] arr = new boolean[42];
	    
	    for(int i=0; i<10; i++) {
	        int n = Integer.parseInt(br.readLine());
	        arr[(n % 42)] = true;
	    }
	    
	    int cnt = 0;
	    
	    for(boolean x : arr) if(x) cnt++;
	    
	    System.out.print(cnt);
	}
}   

