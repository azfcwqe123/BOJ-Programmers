import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0, k = 666;

        while(true) {
            
            if(String.valueOf(k).contains("666")) {
                cnt++;
                if(cnt == n) {
                   System.out.print(k);
                   return;
                }
                k++;
            }
            else k++;
        }
        
    }
}


