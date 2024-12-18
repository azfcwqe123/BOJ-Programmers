import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) map.put(st.nextToken(), 0);
        
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                String tmp = st.nextToken();
                map.put(tmp, map.get(tmp) + 1);
            }
        }
    
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b) -> {
            if(map.get(a) == map.get(b)) return a.compareTo(b);
            
            return map.get(b) - map.get(a);
        });
        
        for(String x : list) {
            sb.append(x + " " + map.get(x)).append("\n");
        }
        
        System.out.print(sb);
    }
    
}

