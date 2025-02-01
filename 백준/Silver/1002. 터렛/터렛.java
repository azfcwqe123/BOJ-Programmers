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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            
            if(x1 == x2 && y1 == y2 && r1 == r2) sb.append(-1);
            
            else if(Math.pow(r1 + r2, 2) < distance) sb.append(0);
            
            else if(Math.pow(r1 - r2, 2) > distance) sb.append(0);
            
            else if(Math.pow(r1 + r2, 2) == distance) sb.append(1);
            
            else if(Math.pow(r1 - r2, 2) == distance) sb.append(1);
            
            else sb.append(2);
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
    }
}

