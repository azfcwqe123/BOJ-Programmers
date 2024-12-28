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
        
        for(int x : map.values()) {
            max = Math.max(x, max);    
        }
        
        ArrayList<Long> list = new ArrayList<>();
        
        for(Long key : map.keySet()) {
            if(map.get(key) == max) list.add(key);
        }
        
        Collections.sort(list);
        
        System.out.print(list.get(0));

    }
    
}
    


