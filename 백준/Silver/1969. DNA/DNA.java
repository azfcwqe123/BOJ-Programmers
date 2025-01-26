import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] DNA = new String[n];
        
        for(int i=0; i<n; i++) DNA[i] = br.readLine();
        
        int sum = 0;
        
        for(int i=0; i<m; i++) {
            int A = 0, T = 0, G = 0, C = 0;
            
            for(int j=0; j<n; j++) {
                
                switch(DNA[j].charAt(i)) {
                    
                    case 'A' : 
                        A++;
                        break;
                        
                    case 'T' :
                        T++;
                        break;
                        
                    case 'G' :
                        G++;
                        break;
                        
                    case 'C' :
                        C++;
                        break;
                }
            }
            
            int max = Math.max(Math.max(A, T), Math.max(G, C));
            sum += n - max;
            
            char ch = max == A ? 'A' : max == C ? 'C' : max == G ? 'G' : 'T';
            
            sb.append(ch);
        }
        
        System.out.println(sb);
        System.out.println(sum);
    }
    
}

