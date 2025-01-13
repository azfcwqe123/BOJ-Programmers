import java.util.*;
import java.io.*;

class Tomato {
    int x;
    int y;
    
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int m, n, ans = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static Queue<Tomato> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) Q.offer(new Tomato(i, j));
            }
        }
        
        BFS();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    System.out.print(-1);
                    System.exit(0);
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void BFS() {
        
        while(!Q.isEmpty()) {
            
            boolean ch = false;
            
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Tomato cur = Q.poll();
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(checkRange(nx, ny) && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        Q.offer(new Tomato(nx, ny));
                        ch = true;
                    }
                }
            }
            
            if(ch) ans++;
        }
        
    }
    
    public static boolean checkRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}
