import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        String str;
        
        while((str = br.readLine()) != null) {
            sb.append(str).append('\n');
        }
        
        System.out.print(sb);
    }
    
}

