import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        StringTokenizer a = new StringTokenizer(str, "1");
        StringTokenizer b = new StringTokenizer(str, "0");
            
        System.out.print(Math.min(a.countTokens(), b.countTokens()));    

    }
    
}

