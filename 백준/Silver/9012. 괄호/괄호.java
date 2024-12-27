import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            System.out.println(check(br.readLine()));
        }
        
        
    }
    
    public static String check(String str) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char x : str.toCharArray()) {
            
            if(x == '(') stack.push(x);
            
            else {
                if(stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }
        
        if(stack.isEmpty()) return "YES";
        else return "NO";
        
    }
}

