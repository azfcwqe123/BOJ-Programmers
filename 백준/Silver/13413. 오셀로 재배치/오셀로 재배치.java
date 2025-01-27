import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            int n = Integer.parseInt(br.readLine());
            
            String a = br.readLine();
            String b = br.readLine();
            
            int W = 0, B = 0;
            
            for(int i=0; i<n; i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    if(a.charAt(i) == 'W')  W++;
                    else B++;
                }
            }
            
            int change = Math.min(W, B); // 자리 교체
            int reverse = Math.abs(W - B); // 뒤집기
            
            sb.append(change + reverse).append('\n');
        }
        
        System.out.print(sb);
    }
    
}

