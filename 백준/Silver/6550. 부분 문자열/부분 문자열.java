import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str;
        
        StringBuilder sb = new StringBuilder();
        
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            
            String s = st.nextToken();
            String t = st.nextToken();
            
            int p1 = 0;
            
            for(int p2 = 0; p2 < t.length(); p2++) {
                if(s.charAt(p1) == t.charAt(p2)) p1++;
                if(p1 == s.length()) break;
            }
            
            String ans = (p1 == s.length()) ? "Yes" : "No";
            sb.append(ans).append('\n');
        }
        
        System.out.print(sb);
    }
}

