import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] arr = new String[5];
	    
	    int max_length = -1;
	    
	    for(int i=0; i<5; i++) {
	        
	        String str = br.readLine();
	        max_length = Math.max(max_length,str.length());
	        
	        arr[i] = str;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<max_length; i++) {
	        
	        for(int j=0; j<5; j++) {
	            
	            if(i < arr[j].length()) {
	                sb.append(arr[j].charAt(i));
	            }
	        }   
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}
	


