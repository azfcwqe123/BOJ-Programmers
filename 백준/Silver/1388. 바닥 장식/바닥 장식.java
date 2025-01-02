import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static char[][] board;
    public static boolean[][] visited;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        
        visited = new boolean[n][m];
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) {
                    if(board[i][j] == '-') {
                        DFS_Row(i, j);
                        ans++;
                    }
                    if(board[i][j] == '|') {
                        DFS_Column(i, j);
                        ans++;
                    }
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void DFS_Row(int x, int y) {
        
        visited[x][y] = true;
        
        if(y+1 < m && board[x][y+1] == '-') {
            DFS_Row(x, y+1);
        }
    }
    
    public static void DFS_Column(int x, int y) {
        
        visited[x][y] = true;
        
        if(x+1 < n && board[x+1][y] == '|') {
            DFS_Column(x+1, y);
        }
    }
}

