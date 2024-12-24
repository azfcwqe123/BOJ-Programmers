import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int sum = 1;
        
        int[] ch = new int[10];
        
        for(int i=0; i<3; i++) {
            int k = Integer.parseInt(br.readLine());
            sum *= k;
        }
        
        while(sum > 0) {
            ch[sum % 10]++;
            sum /= 10;
        }
        
        for(int x : ch) System.out.println(x);
        
    }
    
}

