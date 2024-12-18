import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        
        int ans = 0;
        
        for(int x : A) {
            if(!B.contains(x)) ans++;
        }
        
        for(int x : B) {
            if(!A.contains(x)) ans++;
        }
        
        System.out.print(ans);
        
    }
    
}

