import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr, ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        dfs(0);
        
        System.out.print(sb);
        
    }
    
    static void dfs(int depth) {
        
        if(depth == m) {
            for(int val : ans) sb.append(val + " ");
            sb.append("\n");
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) { // ! 
                visited[i] = true;
                ans[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        
        } 
        
    }
}

