import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char[] arr = br.readLine().toCharArray();
	    
	    int cnt = 0;
	    
	    for(int i=0; i<arr.length; i++) {
	        
	        if(arr[i] == 'c') {
	            if(i+1 < arr.length && (arr[i+1] == '=' || arr[i+1] == '-')) {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else if(arr[i] == 'd') {
	            if(i+1 < arr.length && arr[i+1] == 'z') {
	                if(i+2 < arr.length && arr[i+2] == '=') {
	                    cnt++;
	                    i+=2;
	                } else {
	                    cnt++;
	                }
	            }
	            
	            else if(i+1 < arr.length && arr[i+1] == '-') {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else if(arr[i] == 'l' || arr[i] == 'n' ) {
	            if(i+1 < arr.length && arr[i+1] == 'j') {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else if(arr[i] == 's' || arr[i] == 'z') {
	            if(i+1 < arr.length && arr[i+1] == '=') {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else cnt++;
	        
	    }
	    
	    System.out.print(cnt);
	    
	}
	
}   


