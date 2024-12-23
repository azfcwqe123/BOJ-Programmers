import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) A.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) B.add(Integer.parseInt(st.nextToken()));
        
        TreeSet<Integer> list = new TreeSet<>();
        
        for(int x : A) {
            if(!B.contains(x)) list.add(x);   
        } 
        
        System.out.println(list.size());
        for(int x : list) System.out.print(x + " ");
        
    }
    
}

