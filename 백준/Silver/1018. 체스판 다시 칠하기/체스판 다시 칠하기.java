import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static boolean[][] board;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        board = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                char k = str.charAt(j);
                if(k == 'W') board[i][j] = true;
                else board[i][j] = false;
            }
        }
        
        
        for(int i=0; i<N-7; i++) {
            for(int j=0; j<M-7; j++) {
                check(i, j);
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void check(int a, int b) {
        
        boolean flag = true;
        
        int cnt = 0;
        
        for(int i=a; i<a+8; i++) {
            for(int j=b; j<b+8; j++) {
                if(board[i][j] != flag) cnt++;
                flag = !(flag);
            }
            flag = !(flag);
        }
        
        cnt = Math.min(cnt, 64-cnt);
        
        ans = Math.min(cnt, ans);
    }
    
}

