import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        
        dfs(1, 0);
        
        System.out.print(sb);
    }
    
    static void dfs(int st, int depth) {
        
        if(depth == m) {
            for(int x : arr) sb.append(x + " ");
            sb.append("\n");
            return;
        }
        
        for(int i=st; i<=n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
        
    }
}

