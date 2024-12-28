import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static HashMap<Character, Character> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        
        map.put(')', '(');
        map.put(']', '[');
            
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) return;
            
            if(check(str)) System.out.println("yes");
            else System.out.println("no");
        }
        
    }
    
    public static boolean check(String str) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char x : str.toCharArray()) {
            
            if(x == '(' || x == '[') stack.push(x);
            
            else if(x == ')' || x == ']') {
                    
                if(stack.isEmpty()) return false;
                
                else if(stack.peek().equals(map.get(x))) stack.pop();
                
                else return false;
                    
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
        
    }
            
}
    


