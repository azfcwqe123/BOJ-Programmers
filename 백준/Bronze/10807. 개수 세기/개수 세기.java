import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] arr = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int m = Integer.parseInt(br.readLine());
	    
	    int cnt = 0;
	    
	    for(int x : arr) {
	        if(x==m) cnt++;
	    }
	    
	    System.out.print(cnt);
	    
	}
}   

