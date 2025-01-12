import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        int ans = Math.abs(A - B);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(Math.abs(k - B));
        }
        
        Collections.sort(list);
        
        ans = Math.min(ans, list.get(0) + 1);
        
        System.out.println(ans);
    }
    
}

