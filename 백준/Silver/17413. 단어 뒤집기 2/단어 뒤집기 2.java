import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        Stack<Character> stack = new Stack<>();
        
        String str = br.readLine();
        
        boolean open = false;
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == ' ' || ch == '<') {
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(ch);
                if(ch == '<') open = true;
                continue;
            }
            
            if(open) sb.append(ch);
            else stack.push(ch);
            
            if(ch == '>') open = false;
        }
        
        while(!stack.isEmpty()) sb.append(stack.pop());
        
        System.out.print(sb);
        
    }
    
}

