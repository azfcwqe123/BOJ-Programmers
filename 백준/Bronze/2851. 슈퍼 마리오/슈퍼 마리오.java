import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int ans = Integer.MAX_VALUE;
	    
	    int[] arr = new int[11];
	    int[] sum = new int[11];
	    
	    for(int i=1; i<=10; i++) arr[i] = Integer.parseInt(br.readLine());
	    
	    for(int i=1; i<=10; i++) {
	        sum[i] = sum[i-1] + arr[i];
	        
	        if(Math.abs(sum[i] - 100) < Math.abs(sum[i-1] - 100)) {
	            ans = sum[i];         
	        } else if(Math.abs(sum[i] - 100) == Math.abs(sum[i-1] - 100)) {
	            ans = sum[i];
	        }
	   
	    }
	    
	    System.out.print(ans);
 	    
    }

}