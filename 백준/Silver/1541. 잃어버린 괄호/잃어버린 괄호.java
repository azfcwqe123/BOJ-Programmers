import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String[] arr = br.readLine().split("-");
        
        int ans = 0;
        
        for(int i=0; i<arr.length; i++) {
            
            String[] tmp = arr[i].split("\\+");
            
            if(i==0) for(String k : tmp) ans += Integer.parseInt(k);
            
            else if(i>=1) for(String k : tmp) ans -= Integer.parseInt(k);
            
        }
        
        System.out.print(ans);
        
    }
    
}

