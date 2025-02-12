import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int time;
        boolean destoryed;
        
        Point(int x, int y, int time, boolean destoryed) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destoryed = destoryed;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m][2];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0'; 
            }
        }
        
        System.out.print(BFS());
        
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 1, false));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                // 벽을 부순적이 있을 때
                if(cur.destoryed) {
                    if(map[nx][ny] == 0 && !visited[nx][ny][1]) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                
                // 벽을 부순적이 없을 때
                else {
                    if(map[nx][ny] == 1) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, true));
                        visited[nx][ny][1] = true;
                    }
                    
                    else if(map[nx][ny] == 0 && !visited[nx][ny][0]) {
                        pQ.offer(new Point(nx, ny, cur.time + 1, false));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }
        
        return -1;
        
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
    
}

