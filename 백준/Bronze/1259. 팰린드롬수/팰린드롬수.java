import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            String str = br.readLine();
            
            if(str.equals("0")) return;
            
            if(str.equals(new StringBuilder(str).reverse().toString())) System.out.println("yes");
            else System.out.println("no");
        }
        
    }
    
}

