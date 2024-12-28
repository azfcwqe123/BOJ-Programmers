import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        int start = 1;
        
        StringBuilder sb = new StringBuilder();
        
        while(n-- > 0) {
            
            int k = Integer.parseInt(br.readLine());
            
            if(k >= start) {
                
                for(int i=start; i<=k; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = k + 1;
            }
            
            else if(stack.peek() != k) {
                System.out.print("NO");
                return;
            }
            
            stack.pop();
            sb.append('-').append('\n');
        }
        
        System.out.print(sb);
        
    }
    
}
    


