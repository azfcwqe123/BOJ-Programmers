import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    while(true) {
	        
	        int[] arr = new int[3];
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        arr[0] = Integer.parseInt(st.nextToken());
	        arr[1] = Integer.parseInt(st.nextToken());
	        arr[2] = Integer.parseInt(st.nextToken());
	        
	        if(arr[0]==0 && arr[1]==0 && arr[2]==0) return;
	        
	        Arrays.sort(arr);
	        
	        if(arr[0] + arr[1] > arr[2]) {
	            
	            if(arr[0]==arr[1] && arr[1]==arr[2]) System.out.println("Equilateral");
	            else if(arr[0]==arr[1] || arr[1]==arr[2] || arr[0]==arr[2]) System.out.println("Isosceles");
	            else System.out.println("Scalene");    
	            
	        } else {
	            System.out.println("Invalid");
	        }
	        
       
	    }
	    
	    
	}
}



