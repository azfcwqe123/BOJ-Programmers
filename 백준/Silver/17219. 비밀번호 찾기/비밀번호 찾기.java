import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        HashMap<String, String> map = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            String site = st.nextToken();
            String password = st.nextToken();
            
            map.put(site, password);
        }
        
        for(int i=0; i<m; i++) {
            String tmp = br.readLine();
            
            sb.append(map.get(tmp)).append('\n');
        }
        
        System.out.print(sb);
        
    }
    
}

