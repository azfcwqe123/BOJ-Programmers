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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, p;
    static char[][] board;
    static int[] range;
    static int[] ans;
    static Queue<Point>[] Q;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        range = new int[p+1];
        ans = new int[p+1];
        board = new char[n][m];
        Q = new Queue[p+1];
        
        for(int i=0; i<=p; i++) Q[i] = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=p; i++) range[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    Q[board[i][j] - '0'].offer(new Point(i, j));
                    ans[board[i][j] - '0']++;
                }
            }
        }

        BFS();

        for(int i=1; i<=p; i++) System.out.print(ans[i] + " ");
    }


    static void BFS() {
        
        while(true) {
            
            boolean check = false;
            for(int i=1; i<=p; i++) {
                int size = Q[i].size();
                int cycle = 0;
                
                int cnt = 0;
                int remainCnt = range[i];
                
                while(!Q[i].isEmpty() && cnt < remainCnt) {
                    
                    Point cur = Q[i].poll();
                    for(int d=0; d<4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                            
                        if(!rangeCheck(nx, ny)) continue;
                            
                        if(board[nx][ny] == '.') {
                            board[nx][ny] = board[cur.x][cur.y];
                            ans[board[nx][ny] - '0']++;
                            Q[i].offer(new Point(nx, ny));
                            check = true;
                        }
                    }
                    cycle++;
                    
                    if(size == cycle) {
                        cnt++;
                        size = Q[i].size();
                        cycle = 0;
                    }
                }
            }
            if(!check) break;
        }
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}