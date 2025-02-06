import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static int[][] map;
    public static boolean[][] visited;
    public static int n, m;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    
    static class Point {
        int x;
        int y;
        int cnt;
        
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
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
        
        while(true) {
            
            visited = new boolean[n][m];
            
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] != 0 && !visited[i][j]) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            
            if(cnt >= 2) {
                System.out.print(ans);
                System.exit(0);
            }
            
            if(cnt == 0) {
                System.out.print(0);
                System.exit(0);
            }
            
            else melt();
            
            ans++;
        }
        
    }
    
    public static void melt() {
        
        Queue<Point> Q = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] != 0) {
                    int cnt = 0;
                    
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if(rangeCheck(nx, ny) && map[nx][ny] == 0 && cnt < map[i][j]) {
                            cnt++;
                        }
                    }
                    if(cnt != 0) Q.offer(new Point(i, j, cnt));
                }
            }
        }
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            map[cur.x][cur.y] -= cur.cnt;
        }
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
    public static void DFS(int i, int j) {
        
        visited[i][j] = true;
        
        for(int d=0; d<4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            
            if(rangeCheck(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
    
}

