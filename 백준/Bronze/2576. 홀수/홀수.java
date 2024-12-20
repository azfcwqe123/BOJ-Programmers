import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int sum = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<7; i++) {
            int k = Integer.parseInt(br.readLine());
            
            if(k % 2 != 0) {
                sum += k;
            
                list.add(k);    
            }
            
        }
        
        Collections.sort(list);
        
     
        if(list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(list.get(0));    
        }
        
        
    }
}

