import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char[][] arr = new char[5][15];
	    
	    int max_length = 0;
	    
	    for(int i=0; i<5; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	
	        String str = st.nextToken();
	        max_length = Math.max(max_length, str.length());
	        
	        for(int j=0; j<str.length(); j++) {
	            arr[i][j] = str.charAt(j);    
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<max_length; i++) {
	        
	        for(int j=0; j<5; j++) {
	            if(arr[j][i] == '\u0000') continue;
	            sb.append(arr[j][i]);        
	        }
	    }
	    
	    System.out.print(sb);
	        
	}
	    
}
	


