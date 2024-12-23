import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) set.add(Integer.parseInt(st.nextToken()));
        
        for(int x : set) System.out.print(x + " ");
    }
    
}

