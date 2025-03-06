import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int len = str.length();
        
        for(int i=0; i<len; i++) {
            sb.append(str.charAt(i));
            if(i % 10 == 9) sb.append('\n');
        }
        
        System.out.print(sb);
        
    }
    
}

