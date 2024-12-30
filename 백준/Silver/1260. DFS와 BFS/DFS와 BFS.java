import java.util.*;
import java.io.*;


class Main {

    public static int n, m, start;
    public static int[][] graph;
    public static boolean[] ch;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        
        graph = new int[n+1][n+1];
        ch = new boolean[n+1];
        
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }
        
        DFS(start);
        sb.append('\n');
        
        ch = new boolean[n+1];
        BFS(start);
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int start) {
        
        ch[start] = true;
        sb.append(start + " ");
        
        for(int i=1; i<=n; i++) {
            if(graph[start][i] == 1 && !ch[i]) {
                DFS(i);
            }
        }
    }
    
    public static void BFS(int start) {
        
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        ch[start] = true;
        
        while(!Q.isEmpty()) {
            start = Q.poll();
            sb.append(start + " ");
            
            for(int i=1; i<=n; i++) {
                if(graph[start][i] == 1 && !ch[i]) {
                    Q.add(i);
                    ch[i] = true;
                }
            }
        }
    }
    
}


