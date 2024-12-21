import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        TreeSet<String> set = new TreeSet<>();
        
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) set.add(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) set.add(st.nextToken());
        
        int n = set.size();
        
        StringBuilder sb = new StringBuilder();
        
        for(String x : set) {
            for(String y : set) {
                sb.append(x + " " + y).append('\n');
            }
        }
        
        System.out.print(sb);
        
    }
}



