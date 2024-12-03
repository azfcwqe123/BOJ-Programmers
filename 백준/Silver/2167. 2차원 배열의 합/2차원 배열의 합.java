import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
 	    
 	    int[][] arr = new int[n+1][m+1];
 	    int[][] prefixSum = new int[n+1][m+1];
 	    
 	    for(int i=1; i<=n; i++) {
 	        st = new StringTokenizer(br.readLine());
 	        for(int j=1; j<=m; j++) {
 	            arr[i][j] = Integer.parseInt(st.nextToken());
 	            prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + arr[i][j];
 	        }
 	    }
 
 	    
 	    int k = Integer.parseInt(br.readLine());
 	    
 	    for(int l=0; l<k; l++) {
 	        st = new StringTokenizer(br.readLine());
 	        
 	        int i = Integer.parseInt(st.nextToken());
 	        int j = Integer.parseInt(st.nextToken());
 	        int x = Integer.parseInt(st.nextToken());
 	        int y = Integer.parseInt(st.nextToken());
 	        
 	        int ans = prefixSum[x][y] - prefixSum[i-1][y] - prefixSum[x][j-1] + prefixSum[i-1][j-1];
 	        
 	        System.out.println(ans);
 	    }
 	    
    }

}