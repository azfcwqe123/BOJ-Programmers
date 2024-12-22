import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        String docu = br.readLine();
        String k = br.readLine();
        
        int ans = 0;
        
        for(int i=0; i<docu.length(); i++) {
            
            if(docu.substring(i).startsWith(k)) {
                ans++;
                i += k.length() - 1; // for문의 조건 i++ 때문에 -1을 해줘야함.
            }
            
        }
        
        System.out.print(ans);
    }
}


