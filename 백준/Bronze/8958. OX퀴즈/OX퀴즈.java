import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            
            int sum = 0, i = 0;
            
            for(char x : br.readLine().toCharArray()) {
                if(x == 'O') sum += ++i;
                else i = 0;
            }
            System.out.println(sum);
        }
        
    }
        
}

