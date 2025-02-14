import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int time;
        
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        Point(int x, int y) {
            this(x, y, 0);
        }
        
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, ans = 10000000;
    static int[][] map;
    static boolean[][] visited;
    static int setLandNum = 1;
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    setLand(i, j, setLandNum);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] != 0) {
                    visited = new boolean[n][n];
                    makeBridge(i, j, map[i][j]);
                }
            }
        }
        
        System.out.println(ans);
    }
    
    static void setLand(int x, int y, int num) {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(x, y));
        map[x][y] = num;
        visited[x][y] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                    pQ.offer(new Point(nx, ny));
                }
            }
        }
        setLandNum++;
    }
    
    static void makeBridge(int x, int y, int land) {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(x, y));
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                if(map[nx][ny] != 0 && map[nx][ny] != land) {
                    ans = Math.min(ans, cur.time);
                    return;
                }
                
                if(map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pQ.offer(new Point(nx, ny, cur.time + 1));
                }
                
            }
            
        }
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<n && ny<n;
    }
    
}

