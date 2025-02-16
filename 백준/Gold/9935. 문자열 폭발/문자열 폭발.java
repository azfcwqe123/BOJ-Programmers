import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        String TNT = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int TNT_Size = TNT.length();
        
        for(char x : str.toCharArray()) {
            
            stack.push(x);
            
            if(stack.size() >= TNT_Size) {
                
                boolean flag = true;
                
                for(int j=0; j<TNT.length(); j++) {
                    if(stack.get(stack.size() - TNT_Size + j) != TNT.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    for(int j=0; j<TNT_Size; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        for(char x : stack) sb.append(x);
        
        System.out.print(sb.length() == 0 ? "FRULA" : sb);
    }
    
}

