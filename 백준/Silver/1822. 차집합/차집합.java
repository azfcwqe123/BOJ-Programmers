import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) set.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) set.remove(Integer.parseInt(st.nextToken()));
        
        StringBuilder sb = new StringBuilder();
        System.out.println(set.size());
        for(int x : set) sb.append(x + " ");
        
        System.out.print(sb);
        
    }
    
}

