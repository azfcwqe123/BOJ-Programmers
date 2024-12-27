import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(st.nextToken());
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int ch = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(ch)) sb.append(map.get(ch) + " ");
            else sb.append("0 ");
        }
        
        System.out.print(sb);
    }
    
}

