import java.util.*;
import java.math.BigInteger;
import java.io.*;

class Main {
    
    static class Point {
        
        int x;
        int y;
        int cnt = 0;
        
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[][] map, ans;
    static boolean[][] visited;
    static Queue<Point> Q = new LinkedList<>();
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        ans = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) Q.offer(new Point(i, j, 0));
            }
        }
        
        BFS();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] != 2 && map[i][j] != 0 && ans[i][j] == 0) sb.append(-1 + " ");
                else sb.append(ans[i][j] + " ");
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void BFS() {
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    Q.offer(new Point(nx, ny, cur.cnt + 1));
                    visited[nx][ny] = true;
                    ans[nx][ny] = cur.cnt + 1;
                }
            }
        }
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}

