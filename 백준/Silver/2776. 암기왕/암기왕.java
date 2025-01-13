import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0 ) {
            StringBuilder sb = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));
            
            int M = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int k = Integer.parseInt(st.nextToken());
                if(set.contains(k)) sb.append("1");
                else sb.append("0");
                
                sb.append("\n");
            }
            
            System.out.print(sb);
        }
        
    }
    
}

