import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int[][] board;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                if(str.charAt(j) == '.') continue;
                board[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                check(i, j);
            }
            System.out.println();
        }
        
    }
    
    static void check(int x, int y) {
        
        if(board[x][y] != 0) { 
            System.out.print('*');
            return;
        }
        
        int cnt = 0;
        
        for(int d=0; d<8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            
            if(board[nx][ny] != 0) cnt += board[nx][ny];
        }
        
        char tmp = (cnt >= 10) ? 'M' : (char) (cnt + '0');
        
        System.out.print(tmp);
    }
}

