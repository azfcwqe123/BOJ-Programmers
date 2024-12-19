import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(n-- > 0) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        while(m-- > 0) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        int cnt = 0 ;
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String x : map.keySet()) {
            if(map.get(x) == 2) {
                list.add(x);
                cnt++;
            }
        }
        
        list.sort((a,b) -> a.compareTo(b));
        
        for(String x : list) {
            sb.append(x).append('\n');    
        }
        
        System.out.println(cnt);
        System.out.print(sb);
        
    }
    
}

