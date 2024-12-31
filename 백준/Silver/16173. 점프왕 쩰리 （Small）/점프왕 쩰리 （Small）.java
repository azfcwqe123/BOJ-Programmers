import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int[][] map; 
    public static boolean[][] visited;
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
        
        System.out.print(BFS(0, 0));
        
    }
    
    public static String BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            Point cur = Q.poll();
            
            if(cur.x == n-1 && cur.y == n-1) return "HaruHaru";
            
            int move = map[cur.x][cur.y];
            
            for(int i=0; i<len; i++) {
                
                if(cur.x < n && cur.y + move < n && !visited[cur.x][cur.y + move]) {
                    visited[cur.x][cur.y + move] = true;
                    Q.offer(new Point(cur.x, cur.y + move));
                }
                
                if(cur.x + move < n && cur.y < n && !visited[cur.x+move][cur.y]) {
                    visited[cur.x + move][cur.y] = true;
                    Q.offer(new Point(cur.x + move, cur.y));
                }
                
            }
            
        }
        
        return "Hing";
        
    }
    
}

