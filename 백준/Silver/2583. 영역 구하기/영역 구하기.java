import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static boolean[][] map;
    public static int h, w, k;
    public static int x1, y1, x2, y2;
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    static class Point {
        
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new boolean[h][w];
        
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int i=y1; i<y2; i++) {
                for(int j=x1; j<x2; j++) {
                    map[i][j] = true;
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(!map[i][j]) {
                    list.add(BFS(i, j));
                    ans++;
                }
            }
        }
        
        Collections.sort(list);
        
        sb.append(ans).append("\n");
        for(int x : list) sb.append(x + " ");
        
        System.out.print(sb);
        
    }
    
    public static int BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        int tmp = 1;
        map[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point cur = Q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(rangeCheck(nx, ny) && !map[nx][ny]) {
                    map[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                    tmp++;
                }
            }
        }
        
        return tmp;
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < h && ny < w;
    } 
    
}

