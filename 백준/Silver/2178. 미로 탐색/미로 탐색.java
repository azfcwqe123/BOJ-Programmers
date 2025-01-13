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
    
    public static int[][] map;
    public static int n, m, ans = 1;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        BFS();
        
        System.out.print(map[n-1][m-1]);
    }
    
    public static void BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0));
        
        while(!Q.isEmpty()) {
            
            Point cur = Q.poll();
            
            for(int i=0; i<4; i++) {
                
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
                
            }
        }
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
    
}

