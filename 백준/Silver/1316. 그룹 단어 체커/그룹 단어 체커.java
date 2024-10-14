import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int cnt = n;
	    
	    for(int i=0; i<n; i++) {
	        String str = br.readLine();
	        int prev = 0;
	        boolean[] arr = new boolean[26];
	        
	        for(int j=0; j<str.length(); j++) {
	            
	            int now = str.charAt(j);
	            
	            if (now != prev){ 
	                if(arr[now-97] == false) {
	                    arr[now-97] = true;
	                    prev = now;
	                }
	                else {
	                    cnt--;
	                    break;
	                }
	            }
	            
	            else continue;
	            
	        }
	        
	    }
	    
	    System.out.print(cnt);
	    
	}
	
}   


