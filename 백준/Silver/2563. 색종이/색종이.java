import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    boolean[][] arr = new boolean[101][101];
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int cnt = 0;
	    
	    for(int i=0; i<n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        for(int j=b; j<b+10; j++) {
	            
	            for(int k=a; k<a+10; k++) {
	                if(arr[j][k] == false) {
	                    arr[j][k] = true;
	                    cnt++;                
	                }
	            }
	        }
	    }
	    
	    System.out.print(cnt);
	    
	}
	    
}
	


