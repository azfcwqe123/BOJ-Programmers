import java.util.*;
import java.io.*;


class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[] arr1 = new int[n];
	    int[] arr2 = new int[m];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr1[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<m; i++) {
	        arr2[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    int p1 = 0, p2 = 0;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(p1 < n && p2 < m) {
	        
	        if(arr1[p1] < arr2[p2]) sb.append(arr1[p1++] + " ");
	        else sb.append(arr2[p2++] + " ");
	        
	    }
	    
	    while(p1 < n) sb.append(arr1[p1++] + " ");
	    while(p2 < m) sb.append(arr2[p2++] + " ");
	    
	    
	    System.out.print(sb);
	    
    }
    
}