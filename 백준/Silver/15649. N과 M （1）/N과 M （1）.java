import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        visited = new boolean[n];
        arr = new int[m];
        
        DFS(0);
        
        System.out.print(sb);
    }
    
    static void DFS(int depth) {
        
        if(depth == m) {
            for(int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
        
    }
}

