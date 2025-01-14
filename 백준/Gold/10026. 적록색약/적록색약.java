import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int n;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        board = new char[n][n];
        
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        System.out.print(notCbn());
        
        for(int i=0; i<visited.length; i++) {
            Arrays.fill(visited[i], false);    
        }
        
        System.out.print(" " + Cbn());
    }
    
    public static int notCbn() {
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    DFS(board[i][j], i, j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public static int Cbn() {
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'G') board[i][j] = 'R';
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    DFS(board[i][j], i, j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public static void DFS(char color, int x, int y) {
        
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(rangeCheck(nx, ny) && !visited[nx][ny] && board[nx][ny] == color) {
                visited[nx][ny] = true;
                DFS(color, nx, ny);
            }
        }
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}

