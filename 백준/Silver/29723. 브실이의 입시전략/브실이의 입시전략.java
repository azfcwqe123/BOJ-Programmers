import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int max = 0, min = 0;
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            String sub = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            
            map.put(sub, score);
        }
        
        for(int i=0; i<k; i++) {
            String ch = br.readLine();
            
            max += map.get(ch);
            min += map.get(ch);
            
            map.remove(ch);
        }
        
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        list.sort((key1, key2) -> map.get(key1) - map.get(key2));
        
        int size = n - k - 1;
        
        for(int i = 0; i < m - k; i++) min += map.get(list.get(i));
        for(int i = size; i > size - (m - k); i--) max += map.get(list.get(i));
        
        System.out.print(min + " " + max);
    }
    
}

