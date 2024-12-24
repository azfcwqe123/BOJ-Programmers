import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        
        while(st.hasMoreTokens()) {
            int k = Integer.parseInt(st.nextToken());
            sum += k*k;
        }
        
        System.out.print(sum % 10);
        
    }
    
}

