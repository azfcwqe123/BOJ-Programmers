import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackR = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        
        int ans = 0;
        
        for(char x : str.toCharArray()) {
            
            if(Character.isDigit(x)) ans++;
            
            else {
                if(x == 'L') stackL.push(x);

                else if(x == 'S') stackR.push(x);
                
                else if(x == 'R') {
                    if(stackL.isEmpty()) break;
                    else {
                        ans++;
                        stackL.pop();
                    }
                }
                
                else if(x == 'K') {
                    if(stackR.isEmpty()) break;
                    else {
                        ans++;
                        stackR.pop();
                    }
                }
            }
        }
        
        System.out.print(ans);
        
    }
    
}

