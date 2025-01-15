import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    static class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int n, m;
    public static char[][] map;
    public static Queue<Pos> fQ = new LinkedList<>();
    public static Queue<Pos> pQ = new LinkedList<>();
    
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') pQ.offer(new Pos(i, j));
                if(map[i][j] == 'F') fQ.offer(new Pos(i, j));
            }
        }
        
        int ans = BFS();
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
        
    }
    
    public static int BFS() {
        
        int cnt = 0;
        
        while(!pQ.isEmpty()) {
            
            int len = pQ.size();
            
            for(int i=0; i<len; i++) {
                Pos cur = pQ.poll();
                
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];    
                    
                    if(!rangeCheck(nx, ny) && map[cur.x][cur.y] != 'F') return cnt + 1;
                    
                    if(rangeCheck(nx, ny) && map[nx][ny] == '.') {
                        map[nx][ny] = 'J';
                        pQ.offer(new Pos(nx, ny));
                    }    
                }
            }
            cnt++;
            
            len = fQ.size();
            for(int i=0; i<len; i++) {
                Pos cur = fQ.poll();
                
                int tmp = 0;
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];    
                    
                    if(rangeCheck(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'J')) {
                        map[nx][ny] = 'F';
                        fQ.offer(new Pos(nx, ny));
                    }
                }
            }
            
        }
        
        return -1;
        
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}

