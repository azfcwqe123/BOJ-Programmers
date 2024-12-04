import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    long[] arr = new long[n+1];
	    long[] sum = new long[n+1];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=1; i<=n; i++) arr[i] = Long.parseLong(st.nextToken());
	    
	    for(int i=1; i<=n; i++) sum[i] = sum[i-1] + arr[i];
	    
	    
	    long ans = 0;
	    for(int i=1; i<n; i++) ans += (sum[n] - sum[i]) * arr[i];    
	    
	    
	    System.out.print(ans);
	    
    }

}