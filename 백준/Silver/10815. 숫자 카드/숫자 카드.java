import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) set.add(Integer.parseInt(st.nextToken()));
   
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        while(m-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            
            if(set.contains(k)) System.out.print("1 ");
            else System.out.print("0 ");
        }

    }
    
}

