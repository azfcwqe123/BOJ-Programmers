import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String[][] map;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        
        for(int i=0; i<n; i++) Arrays.fill(map[i], " ");
        star(0, 0, n);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
        
    }
    
    static void star(int x, int y, int n) {
        
        if(n==1) {
            map[x][y] = "*";
            return;
        }
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(!(i==1 && j==1)) star(x + i * (n / 3), y + j * (n / 3), n / 3);
            }
        }
    }
}

