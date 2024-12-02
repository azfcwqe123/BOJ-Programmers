import java.util.*;
import java.io.*;


class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    for(int i=0; i<n; i++) {
	        arr[i] = i+1;
	    }
	    
	    int lt = 0, rt = 0;
	    
	    int sum = 0, cnt = 0;
	    
	    while(rt < n) {
	        sum += arr[rt++];
	        
	        if(sum == n) cnt++;
	        
	        while(sum >= n) {
	            sum -= arr[lt++];
	            if(sum == n) cnt++;
	        }
	        
	    }
	    
	    System.out.print(cnt);
	    
    }
    
}