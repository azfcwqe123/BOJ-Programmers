import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int top = Integer.parseInt(st.nextToken());
            
            while(!stack.isEmpty()) {
                if(stack.peek()[1] <= top) stack.pop();
                else break;
            }
            
            if(stack.isEmpty()) sb.append("0 ");
            else sb.append(stack.peek()[0] + " ");
            
            stack.push(new int[] {i, top});
        }
        
        System.out.print(sb);
    }
    
}

