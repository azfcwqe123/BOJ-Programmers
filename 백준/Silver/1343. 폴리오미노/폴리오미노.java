import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int x = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++) {
            
            if(str.charAt(i) == '.') {
                sb.append(".");
                x = 0;
            }
            
            if(str.charAt(i) == 'X') {
                x++;
                    
                if(x == 2) {
                    if(i+1 < str.length() && str.charAt(i+1) == '.') {
                        sb.append("BB");
                        x = 0;
                    }
                    
                    else if(i == str.length() - 1) {
                        sb.append("BB");
                        x = 0;
                    }
                    
                }    
                    
                if(x == 4) {
                    sb.append("AAAA");
                    x = 0;
                }
                
            }
            
        }
        
        String ans = sb.toString();
        
        if(ans.length() != str.length()) System.out.print(-1);
        else System.out.print(ans);
        
    }
    
}

