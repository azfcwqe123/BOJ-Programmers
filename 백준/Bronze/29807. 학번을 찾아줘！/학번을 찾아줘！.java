import java.io.*;
import java.util.*;

class Main {
    
    static int sum = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    int[] P = new int[5];
	
	    int ans = 0;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());    
	    for(int i=0; i<N; i++) {
	        P[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    if(P[0] > P[2]) ans += (P[0] - P[2]) * 508;
	    else ans += (P[2] - P[0]) * 108;
	    
	    if(P[1] > P[3]) ans += (P[1] - P[3]) * 212;
	    else ans += (P[3] - P[1]) * 305;
	    
	    if(N == 5) ans += P[4] * 707;
	    
	    System.out.print(ans * 4763);
	}
	
}
