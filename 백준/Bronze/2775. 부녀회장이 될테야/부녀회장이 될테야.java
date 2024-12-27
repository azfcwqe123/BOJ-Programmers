import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        int[][] apt = new int[15][15];
        
        for(int i=0; i<15; i++) {
            apt[i][1] = 1;
            apt[0][i] = i;
        }
        
        for(int i=1; i<15; i++) {
            
            for(int j=2; j<15; j++) {
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
        
        while(T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            
            System.out.println(apt[a][b]);
        }
        
    }
    
}

