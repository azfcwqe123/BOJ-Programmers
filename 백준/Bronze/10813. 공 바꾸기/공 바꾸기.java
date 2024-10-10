import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    for(int i=0; i<n; i++) {
	        arr[i] = i+1;
	    }
	    
	    while(m-- > 0) {
	        st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        swap(arr, a-1, b-1);
	    }
	    
	    for(int x : arr) {
	        System.out.print(x + " ");
	    }
	    
	}
	
	static void swap(int[] arr, int a, int b) {
	    int tmp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = tmp;
	}
	
}   

