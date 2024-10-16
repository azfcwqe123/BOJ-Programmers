import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int[][] arr = new int[N][M];
	    
	    for(int i=0; i<N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++) {
	            arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++) {
	            arr[i][j] += Integer.parseInt(st.nextToken());
	            sb.append(arr[i][j] + " ");          
	        }
	        sb.append('\n');
	    }
	    
	    System.out.print(sb);
	        
	}
	    
}
	


