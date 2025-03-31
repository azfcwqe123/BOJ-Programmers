import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] num, arr;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        num = new int[n];
        arr = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        
        dfs(0);
        
        System.out.print(sb);
        
    }
    
    static void dfs(int depth) {
        
        if(depth == m) {
            for(int x : arr) sb.append(x + " ");
            sb.append("\n");
            return;
        } 
        
        for(int i=0; i<n; i++) {
            arr[depth] = num[i];
            dfs(depth + 1);
        }
        
    }
}

