import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static int n, m, cnt=0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1) {
                    ans = Math.max(ans, BFS(i, j));
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
        System.out.println(ans);
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        map[x][y] = 0;
        
        int area = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Point cur = Q.poll();
                area++;
                
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        Q.offer(new Point(nx, ny));
                    }
                }    
            }
        }
        
        return area;
        
    }
    
    private static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}

