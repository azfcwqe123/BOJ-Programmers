import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static String[][] board = new String[5][5];
    public static HashSet<String> set = new HashSet<>();
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        
        
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                board[i][j] = st.nextToken();
            }
        }
        
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                DFS(i, j, board[i][j], 1);
            }
        }
        
        System.out.print(set.size());
        
    }
    
    public static void DFS(int x, int y, String tmp, int cnt) {
        
        if(cnt == 6) {
            set.add(tmp);
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            
            if(nX >= 0 && nX < 5 && nY >= 0 && nY < 5) {
                DFS(nX, nY, tmp + board[nX][nY], cnt + 1);
            }
        }
        
    }
    
}

