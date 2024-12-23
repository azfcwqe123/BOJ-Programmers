import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            String str = br.readLine();
            
            if(str.equals("0")) return;
            
            int n = Integer.parseInt(str);
            
            StringBuilder sb = new StringBuilder();
            while(n > 0) {
                sb.append(n % 10);
                n /= 10;
            }
            
            if(str.equals(sb.toString())) System.out.println("yes");
            else System.out.println("no");
            
        }
        
    }
    
}

