import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        while(N-- > 0) {
            set.add(br.readLine());
        }
        
        int cnt = 0;
        while(M-- > 0) {
            if(set.contains(br.readLine())) cnt++;
        }
        
        System.out.print(cnt);

    }
    
}
    


