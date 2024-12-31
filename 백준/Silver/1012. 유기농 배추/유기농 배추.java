import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int m, n, k;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            int ans = 0;
            
            map = new int[n][m];
            
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 1) {
                        DFS(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans + "\n");
        }
        
        System.out.print(sb);
    }
    
    public static void DFS(int y, int x) {
        
        map[y][x] = 0;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(range_Check(ny, nx) && map[ny][nx] == 1) {
                map[ny][nx] = 0;
                DFS(ny, nx);
            }
        }
        
    }
    
    public static boolean range_Check(int ny, int nx) {
        return (nx >= 0 && ny >= 0 && nx < m && ny < n);
    }
}

