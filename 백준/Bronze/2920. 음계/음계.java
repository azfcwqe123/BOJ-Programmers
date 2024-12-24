import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreTokens()) sb.append(Integer.parseInt(st.nextToken()));   
        
        if(sb.toString().equals("12345678")) System.out.print("ascending");
        else if(sb.toString().equals("87654321")) System.out.print("descending");
        else System.out.print("mixed");
    }
        
}

