import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(list, (a, b) -> b - a);
        
        for(int x : list) sb.append(x).append('\n');
        
        System.out.print(sb);
    }
    
}

