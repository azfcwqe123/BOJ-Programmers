import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[N];
	    
	    for(int i=0; i<M; i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());
	        
	        for(int j=a-1; j<b; j++) arr[j] = k;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int x : arr) {
	        sb.append(x + " ");
	    }
	    
	    System.out.print(sb);
	    
	}
}   

