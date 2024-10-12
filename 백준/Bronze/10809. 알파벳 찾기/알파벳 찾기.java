import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine();
	    
	    int[] arr = new int[26];
	    
	    for(int i=0; i<26; i++) {
	        arr[i] = -1;
	    }
	    
	    for(int i=0; i<str.length(); i++) {
	        if(arr[str.charAt(i) - 'a'] == -1 ) arr[str.charAt(i) - 'a'] = i;
	    }
	    
	    for(int x : arr) {
	        System.out.print(x + " ");
	    }
	    
	}
	
}   


