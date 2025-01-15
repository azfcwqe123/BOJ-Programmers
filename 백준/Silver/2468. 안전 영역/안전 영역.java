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
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int[][] map;
    public static boolean[][] visited;
    public static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        
        int ans = 1;
        
        for(int i=min; i<=max; i++) {
            int tmp = 0;
            visited = new boolean[n][n];
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(map[j][k] > i && !visited[j][k]) {
                        BFS(i, j, k);
                        tmp++;
                    }
                }
            }
            ans = Math.max(ans, tmp);
        }
        
        System.out.print(ans);
        
    }
    
    public static void BFS(int hill, int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny) && map[nx][ny] > hill && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
        
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
    
}

