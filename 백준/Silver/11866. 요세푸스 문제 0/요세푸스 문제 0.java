import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> Q = new LinkedList<>();
        
        for(int i=1; i<=N; i++) Q.offer(i);
        
        StringBuilder sb = new StringBuilder("<");
        
        while(!Q.isEmpty()) {
            
            for(int i=0; i<K-1; i++) Q.offer(Q.poll());
            
            if(Q.size() == 1) sb.append(Q.poll());
            else sb.append(Q.poll() + ", ");
        }
        sb.append(">");
        
        System.out.print(sb);
    }
    
}

