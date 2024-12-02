import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    int x = Integer.parseInt(br.readLine());
	    
	    int lt = 0, rt = n-1;
	    
	    int cnt = 0;
	    
	    while(lt < rt) {
	        
	        int sum = arr[lt] + arr[rt];
	        
	        if(sum == x) {
	            cnt++;
	            lt++;
	            rt--;
	        }
	        else if(sum < x) lt++;
	        else if(sum > x) rt--;
	    }
	    
	    System.out.print(cnt);
	    
    }
    
}
