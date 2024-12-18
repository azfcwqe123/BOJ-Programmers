import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            String tmp = st.nextToken();
            if(tmp.endsWith("Cheese")) set.add(tmp);
        }
        
        System.out.print(set.size() > 3 ? "yummy" : "sad");
        
    }
    
}

