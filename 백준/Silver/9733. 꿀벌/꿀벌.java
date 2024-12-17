import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>() {{
            put("Re", 0);
            put("Pt", 0);
            put("Cc", 0);
            put("Ea", 0);
            put("Tb", 0);
            put("Cm", 0);
            put("Ex", 0);
        }};
        
        int total = 0;
        
        String input = "";
        
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            
            while(st.hasMoreTokens()) {
                String bee = st.nextToken();
                if(map.containsKey(bee)) map.put(bee, map.get(bee) + 1);
                total++;            
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String x : map.keySet()) {
            
            String per = String.format("%.2f", (double) map.get(x) / total);
            
            sb.append(x + " ").append(map.get(x) + " ").append(per + " ").append("\n");
        }
        
        sb.append("Total " + total + " 1.00");
        System.out.print(sb);
        

    }
    
}

