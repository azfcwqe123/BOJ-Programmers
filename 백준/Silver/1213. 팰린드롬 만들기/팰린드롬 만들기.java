import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int[] alpha = new int[26];
        
        String str = br.readLine();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            alpha[ch - 65]++;
        }
        
        int cnt = 0;
        
        for(int i=0; i<26; i++) {
            if(alpha[i] % 2 == 1) cnt++;
            
            if(cnt > 1) {
                System.out.print("I'm Sorry Hansoo");
                System.exit(0);
            }
        }
        
        
        for(int i=0; i<26; i++) {
            
            if(alpha[i] == 0) continue;
            
            else {
                char ch = (char) (i + 65);
                sb.append(String.valueOf(ch).repeat(alpha[i] / 2));
            }
        }
        
        
        String tmp = new StringBuilder(sb).reverse().toString();
        
        for(int i=0; i<26; i++) {
            if(alpha[i] % 2 == 1) {
                sb.append((char) (i+65));
                break;
            }
        }
        
        sb.append(tmp);
        
        System.out.print(sb);
        
    }
}

