import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            if(k == 0) stack.pop();
            else stack.push(k);
        }
        
        int ans = 0;
        
        for(int x : stack) ans += x;
        
        System.out.print(ans);
        
    }
    
}
    


