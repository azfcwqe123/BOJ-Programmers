import java.util.*;
import java.io.*;

class Tomato {
    int h;
    int x;
    int y;
    
    public Tomato(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int m, n, h, ans = 0;
    public static int[][][] map;
    public static int[] dx = {-1, 0, 0, 1, 0, 0};
    public static int[] dy = {0, 1, -1, 0, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    
    public static Queue<Tomato> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h][n][m];
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) Q.offer(new Tomato(i, j, k));
                }
            }
        }
        
        BFS();
        
        check();
        
    }
    
    public static void BFS() {
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            boolean ch = false;
            
            for(int i=0; i<len; i++) {
                Tomato cur = Q.poll();
                
                for(int j=0; j<6; j++) {
                    int nh = cur.h + dz[j];
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(rangeCheck(nh, nx, ny) && map[nh][nx][ny] == 0) {
                        map[nh][nx][ny] = 1;
                        Q.offer(new Tomato(nh, nx, ny));
                        ch = true;
                    }
                }
            }
            
            if(ch) ans++;
        }
    }
    
    public static boolean rangeCheck(int nh, int nx, int ny) {
        return (nx >= 0 && nx < n) && (ny >= 0 && ny < m) && (nh >= 0 && nh < h);
    }
    
    public static void check() {
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(map[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
}

