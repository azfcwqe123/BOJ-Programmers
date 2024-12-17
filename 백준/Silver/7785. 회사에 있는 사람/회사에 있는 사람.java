import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String log = st.nextToken();
            
            if(log.equals("enter")) {
                set.add(name);
            }
            else if(log.equals("leave")) {
                set.remove(name);
            }
        }
        
        for(String x : set) System.out.println(x);
 

    }
    
}

