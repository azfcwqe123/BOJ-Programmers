import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            pos[i][0] = x;
            pos[i][1] = y;
        }
        
        Arrays.sort(pos, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        
        for(int[] x : pos) System.out.println(x[0] + " " + x[1]);
        
    }
    
}

