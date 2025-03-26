import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int count = 1;
        
        while(true) {
            
            int n = Integer.parseInt(br.readLine());
            
            if(n == 0) break;
            
            sb.append("Group " + count).append("\n");
            
            String[][] name = new String[n][n];
            
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    name[i][j] = st.nextToken();
                }
            }
            
            boolean TF = false;
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(name[i][j].equals("N")) {
                        if(i < j) {
                            sb.append(name[n - j + i][0] + " was nasty about " + name[i][0] + "\n");
                        }
                        else {
                            sb.append(name[i - j][0] + " was nasty about " + name[i][0] + "\n");
                        }
                        
                        TF = true;
                    }
                }
            }
            
            if(!TF) sb.append("Nobody was nasty" + "\n");
            count++;
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}

