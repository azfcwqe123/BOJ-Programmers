import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int[][] map;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static int n, tmp;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    tmp = 1;
                    DFS(i, j);
                    list.add(tmp);
                    ans++;
                }
            }
        }
        
        Collections.sort(list);
        sb.append(ans).append("\n");
        
        for(int x : list) sb.append(x).append("\n");
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int x, int y) {
        
        map[x][y] = 0;
        
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(rangeCheck(nx, ny) && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                tmp++;
                DFS(nx, ny);
            }
        }
        
    }
    
    private static boolean rangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
}

