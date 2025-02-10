import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        int ans = 0;
        
        for(int i=0; i<str.length(); i++) {
            
            if(str.charAt(i) == '(') stack.push('(');
            
            else if(str.charAt(i) == ')') {
                stack.pop();
                if(str.charAt(i-1) == '(') ans += stack.size();
                else ans +=1;
            }
        }
        
        
        System.out.print(ans);
    }
    
}

