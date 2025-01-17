import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int dis;
        
        Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int n, m;
    public static char[][] map;
    public static boolean[][] visited;
    
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    ans = Math.max(ans, BFS(i, j));
                }
            }
        }
        
        System.out.print(ans);
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y, 0));
        visited[x][y] = true;
        
        int max = 0;
        
        while(!Q.isEmpty()) {
            
            Point cur = Q.poll();
            max = Math.max(cur.dis, max);
                
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                    
                if(checkRange(nx,ny) && map[nx][ny] == 'L' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny, cur.dis + 1));
                }
            }
        }       
        
        return max;     
    }
    
    public static boolean checkRange(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
}

