import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int m = Integer.parseInt(br.readLine());
	    
	    int[] arr = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    
	    int lt=0, rt = arr.length - 1;
	    
	    int ans = 0;
	    
	    while(lt < rt) {
	        
	        if(arr[lt] + arr[rt] == m) {
	            ans++;
	            lt++;
	            rt--;
	        }
	        
	        else if(arr[lt] + arr[rt] < m) lt++;
	        
	        else if(arr[lt] + arr[rt] > m) rt--;
	            
	        } 
	    
	    
	    System.out.print(ans);

	    
    }
    
}