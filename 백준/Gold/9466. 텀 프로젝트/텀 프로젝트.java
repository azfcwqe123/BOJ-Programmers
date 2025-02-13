import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            visited = new boolean[k+1];
            finished = new boolean[k+1];
            arr = new int[k+1];
            ans = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i=1; i<=k; i++) {
                DFS(i);
            }
            
            System.out.println(k - ans);
        }
    }
    
    static void DFS(int x) {
        
        if(finished[x]) return;
        
        if(visited[x]) {
            finished[x] = true;
            ans++;
        }    
        
        visited[x] = true;
        DFS(arr[x]);
        finished[x] = true;
        
    }
    
    
}

