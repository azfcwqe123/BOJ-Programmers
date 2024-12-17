import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String, String> map = new HashMap<>();
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String log = st.nextToken();
            
            if(log.equals("enter")) {
                map.put(name, log);
            }
            else if(log.equals("leave")) {
                map.remove(name);
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String x : map.keySet()) list.add(x);
        
        list.sort((a,b) -> b.compareTo(a));
        
        for(String x : list) System.out.println(x); 

    }
    
}

