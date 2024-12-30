import java.util.*;
import java.io.*;

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[][] board;
    public static boolean[][] visited;
    public static int h, w;
    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if(w == 0 && h == 0) break;
            
            board = new int[h][w];
            visited = new boolean[h][w];
            int ans = 0;
            
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        BFS(i, j);
                        ans++;
                    }
                }
            }
            
            sb.append(ans + "\n");
            
        }
        
        System.out.print(sb);
        
    }
    
    public static void BFS(int x, int y) {
        Queue<Node> Q = new LinkedList<>();
        visited[x][y] = true;
        
        Q.offer(new Node(x, y));
        
        while(!Q.isEmpty()) {
            Node cur = Q.poll();
            
            for(int i=0; i<8; i++) {
                int nx = dirX[i] + cur.x;
                int ny = dirY[i] + cur.y;
                
                if(range_check(nx, ny) && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    Q.offer(new Node(nx, ny));
                }
            }
        }
    }
    
    public static boolean range_check(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < h && ny < w);
    }
}



