import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k, cnt;
    static boolean[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[n][m];
        
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            
            map[r][c] = true;
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == true) {
                    cnt = 0;
                    DFS(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        
        System.out.print(ans);
    }
    
    static void DFS(int x, int y) {
        map[x][y] = false;
        cnt++;
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(!rangeCheck(nx, ny)) continue;
            
            if(map[nx][ny]) {
                DFS(nx, ny);
            }
        }
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}

