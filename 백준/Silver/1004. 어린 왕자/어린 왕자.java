import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int cnt = 0;
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int n = Integer.parseInt(br.readLine());
            
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                
                int dis1 = (int) (Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2));
                int dis2 = (int) (Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2));
            
                int k = (int) Math.pow(r, 2);
            
                if(dis1 < k ^ dis2 < k) cnt++;
            }
            
            sb.append(cnt).append("\n");
        }
        
        System.out.print(sb);
    }
    
}

