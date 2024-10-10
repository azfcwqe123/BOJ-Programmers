import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    boolean[] arr = new boolean[30];
	    
	    for(int i=0; i<28; i++) {
	        int n = Integer.parseInt(br.readLine()) - 1;
	        arr[n] = true;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<30; i++) {
	        if(arr[i] != true) sb.append(i+1 + "\n");    
	    }
	    
	    System.out.print(sb);
	    
	}
}   

