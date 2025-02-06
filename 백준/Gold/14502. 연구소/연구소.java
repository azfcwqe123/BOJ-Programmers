import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[][] board;
    static boolean[][] visited;
    static int n, m, ans = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static class Virus {
        int x;
        int y;
        
        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        DFS(0);
        
        System.out.print(ans);
    }
    
    // 백트래킹
    static void DFS(int depth) {
        
        if(depth == 3) {
            ans = Math.max(ans, BFS());
            return;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    DFS(depth + 1);
                    board[i][j] = 0;
                }
            }
        }
    }
    
    static int BFS() {
        Queue<Virus> Q = new LinkedList<>();
        
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 2) Q.offer(new Virus(i, j));
                if(board[i][j] != 0) visited[i][j] = true;
            }
        }
        
        while(!Q.isEmpty()) {
            Virus cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.offer(new Virus(nx, ny));
                } 
            }
        }
        
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) cnt++;
            }
        }
        
        return cnt;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}

