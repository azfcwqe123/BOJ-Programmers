import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        
        while(n-- > 0) set.add(br.readLine());
        
        ArrayList<String> list = new ArrayList<>(set);
        
        Collections.sort(list, (a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });
        
        
        for(String x : list) System.out.println(x);
        
    }
}

