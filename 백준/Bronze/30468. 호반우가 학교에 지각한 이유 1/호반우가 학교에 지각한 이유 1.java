import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int STR = Integer.parseInt(st.nextToken());
        int DEX = Integer.parseInt(st.nextToken());
        int INT = Integer.parseInt(st.nextToken());
        int LUK = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int res = 4*N - (STR + DEX + INT + LUK);

        if(res <= 0) System.out.print(0);
        else System.out.print(res);        
	}
	
}
