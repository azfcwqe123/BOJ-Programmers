import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        Queue<Integer> Q = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; i++) Q.offer(i);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(Q.size() != 1) {
            for(int i=1; i<K; i++) Q.offer(Q.poll());
            sb.append(Q.poll() + ", ");
        }
        
        sb.append(Q.poll() + ">");
        System.out.print(sb);
        
    }
    
}

