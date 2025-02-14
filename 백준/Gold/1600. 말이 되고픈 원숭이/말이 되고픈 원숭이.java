import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int jump;
        int time;
        
        Point(int x, int y, int jump, int time) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.time = time;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int w, h, k;
    static int[][] map;
    static boolean[][][] visited;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        k = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h][w];
        visited = new boolean[h][w][k+1];
        
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(BFS());
        
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == h-1 && cur.y == w-1) return cur.time;
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                    
                if(!rangeCheck(nx, ny)) continue;
                    
                if(map[nx][ny] == 0 && !visited[nx][ny][cur.jump]) {
                    pQ.offer(new Point(nx, ny, cur.jump, cur.time + 1));
                    visited[nx][ny][cur.jump] = true;
                }
            }
            
            if(cur.jump < k) {
                
                for(int d=0; d<8; d++) {
                    int nx = cur.x + hdx[d];
                    int ny = cur.y + hdy[d];
                    
                    if(!rangeCheck(nx, ny)) continue;
                    
                    if(map[nx][ny] == 0 && !visited[nx][ny][cur.jump + 1]) {
                        pQ.offer(new Point(nx, ny, cur.jump + 1, cur.time + 1));
                        visited[nx][ny][cur.jump + 1] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<h && ny<w;
    }
}

