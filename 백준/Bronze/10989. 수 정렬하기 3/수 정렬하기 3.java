import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] cnt = new int[10001];
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=10000; i++) {
            
            while(cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        
        System.out.print(sb);
        
    }
    
}

