import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        HashMap<String, String> mapA = new HashMap<>();
        HashMap<String, String> mapB = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=n; i++) {
            String tmp = br.readLine();
            mapA.put(tmp, String.valueOf(i));
            mapB.put(String.valueOf(i), tmp);
        }
        
        while(m-- > 0) {
            String ch = br.readLine();
            
            if(mapA.containsKey(ch)) sb.append(mapA.get(ch));
            
            else sb.append(mapB.get(ch));
            
            sb.append('\n');
        }
        
        System.out.print(sb);
        
    }
    
}

