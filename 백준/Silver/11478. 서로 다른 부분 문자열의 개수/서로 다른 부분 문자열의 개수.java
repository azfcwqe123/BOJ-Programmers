import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int n = str.length();
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String tmp = str.substring(i, j+1);
                set.add(tmp);
            }
        }
        
        System.out.print(set.size());
    }
    
}
