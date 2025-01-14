import java.util.*;
import java.io.*;

class Knight {
    
    int x;
    int y;
    
    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static boolean[][] visited;
    public static int n, a, b, c, d;
    public static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
            
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            
            // 출발 
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            // 도착
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            
            if(a == c && b == d) sb.append(0);
            else sb.append(BFS(a, b));
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static int BFS(int a, int b) {
        Queue<Knight> Q = new LinkedList<>();
        Q.offer(new Knight(a, b));
        
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Knight cur = Q.poll();
                
                for(int j=0; j<8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(nx == c && ny == d) return cnt + 1;
                
                    if(rangeCheck(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        Q.offer(new Knight(nx, ny));
                    }
                }    
            }
            cnt++;
        }
        
        return cnt;
    }
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}

