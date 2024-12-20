import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(N-- > 0) {
            String book = br.readLine();
            
            map.put(book, map.getOrDefault(book, 0) + 1);
        }
        
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b) -> {
            if(map.get(a) == map.get(b)) return a.compareTo(b);
            else return map.get(b) - map.get(a);
        });
        
        System.out.print(list.get(0));

    }
    
}

