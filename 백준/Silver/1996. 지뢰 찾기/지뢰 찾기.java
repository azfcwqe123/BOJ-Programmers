import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static char[][] board;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = str.charAt(j);
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
        
        if(Character.isDigit(board[x][y])) { 
            System.out.print('*');
            return;
        }
        
        int cnt = 0;
        
        for(int d=0; d<8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(!(nx >= 0 && nx < n && ny >= 0 && ny < n)) continue;
            
            if(Character.isDigit(board[nx][ny])) cnt += board[nx][ny] - '0';
            
        }
        
        char tmp = (cnt >= 10) ? 'M' : (char) (cnt + '0');
        
        System.out.print(tmp);
    }
}

