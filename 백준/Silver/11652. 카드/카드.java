import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Long, Integer> map = new HashMap<>();
        
        while(n-- > 0) {
            long k = Long.parseLong(br.readLine());
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int max = 0;
        long ans = 0;
        
        for(long key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                ans = key;
            }
            
            else if(map.get(key) == max) {
                ans = Math.min(key, ans);
            }
        }
        
        System.out.print(ans);

    }
    
}
    


