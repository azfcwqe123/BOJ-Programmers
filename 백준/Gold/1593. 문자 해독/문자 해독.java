import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        
        HashMap<Character, Integer> mapA = new HashMap<>();
        String W = br.readLine();
        for(char x : W.toCharArray()) mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        
        String str = br.readLine();
        HashMap<Character, Integer> mapB = new HashMap<>();
        
        int ans = 0;
        
        for(int i=0; i<g; i++) {
            char ch = str.charAt(i);
            
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
            
            if(i == w-1) {
                if(mapA.equals(mapB)) ans++;    
            }
            
            if(i >= w) {
                char tmp = str.charAt(i-w);
                
                if(mapB.get(tmp) > 1) {
                    mapB.put(tmp, mapB.get(tmp) - 1);
                } else mapB.remove(tmp);
                
                if(mapA.equals(mapB)) ans++;    
            }
        }
        
        System.out.print(ans);
        
    }
    
}

