import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n+1];
	    int[] sum = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1; i<=n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i=1; i<=n; i++) {
	        sum[i] = sum[i-1] + arr[i];
	    }
	    
	    int max = Integer.MIN_VALUE;
	    
	    for(int i=0; i<n-k+1; i++) {
	        max = Math.max(max, sum[k+i] - sum[i]);
	    }
	    
	    System.out.print(max);
	    
	    
    }
    
}
