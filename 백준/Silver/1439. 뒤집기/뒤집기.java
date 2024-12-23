import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int cnt = 0;
        
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) != str.charAt(i-1)) cnt++;
        }
        
        System.out.print((int) Math.ceil((double) cnt / 2));

    }
    
}

