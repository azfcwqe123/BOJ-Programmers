import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            
            int[] P = new int[3];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            P[0] = Integer.parseInt(st.nextToken());
            P[1] = Integer.parseInt(st.nextToken());
            P[2] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(P);
            
            if(P[0] == 0 && P[1] == 0 && P[2] == 0) return;
            
            if(P[2]*P[2] == P[0]*P[0] + P[1]*P[1]) {
                System.out.println("right");
            } else System.out.println("wrong");
            
        }
        
	} 
	
}
