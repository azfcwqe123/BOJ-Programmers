import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        
        int x;
        int y;
        int time;
        int destoryed;
        
        Point(int x, int y, int time, int destoryed) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.destoryed = destoryed;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0 , 1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        
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
        pQ.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == n-1 && cur.y == m-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(!rangeCheck(nx, ny)) continue;
                
                // 벽이 있을떄
                if(map[nx][ny] == 1 && cur.destoryed < k && !visited[nx][ny][cur.destoryed + 1]) {
                    pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed + 1));
                    visited[nx][ny][cur.destoryed + 1] = true;
                }
                
                // 벽이 없을떄
                else if(map[nx][ny] == 0 && !visited[nx][ny][cur.destoryed]) {
                    pQ.offer(new Point(nx, ny, cur.time + 1, cur.destoryed));
                    visited[nx][ny][cur.destoryed] = true;
                }
            }
        }
        
        return -1;
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 & nx<n && ny<m;
    }
    
}

