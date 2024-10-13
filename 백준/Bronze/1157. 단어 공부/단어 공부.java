import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine().toUpperCase();
	    
	    int[] arr = new int[26];
	    
	    for(int i=0; i<str.length(); i++) {
	        arr[str.charAt(i) - 'A']++;
	    }
	    
	    int max = 0;
	    int index = 0;
	    
	    for(int i=0; i<26; i++) {
	        if(arr[i] > max) {
	            max = arr[i];
	            index = i;
	        }
	    }
	    
	    int cnt = 0;
	    
	    for(int x : arr) {
	        if(x==max) cnt++;
	    }
	    
	    if(cnt >= 2) System.out.print("?");
	    else System.out.print((char) (index + 65));
	    
	    
	}
	
}   


