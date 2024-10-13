import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] arr = new int[n+1];
	    int[] sum = new int[n+1];
	    
	    for(int i=1; i<=n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int m = Integer.parseInt(st.nextToken());
	        
	        for(int j=0; j<m; j++) {
	            arr[i] += Integer.parseInt(st.nextToken());    
	        }
	    }
	    
	    Arrays.sort(arr);
	    
	    long ans = 0;
	    for(int i=1; i<=n; i++) {
	        sum[i] = sum[i-1] + arr[i];
	        ans += sum[i];
	    }
	    
	    System.out.print(ans);
	    
	}
	
}   


