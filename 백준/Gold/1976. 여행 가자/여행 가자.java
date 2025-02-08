import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] unf;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        unf = new int[n+1];
        
        for(int i=1; i<=n; i++) unf[i] = i;
        
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                int ch = Integer.parseInt(st.nextToken());
                if(ch == 1) Union(i, j);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<m; i++) {
            int now = Integer.parseInt(st.nextToken());
            
            if(start != Find(now)) {
                System.out.print("NO");
                System.exit(0);
            }
        }
        
        System.out.print("YES");
        
    } 
    
    static void Union(int i, int j) {
        
        int fa = Find(i);
        int fb = Find(j);
        
        if(fa != fb) unf[fa] = fb;
    }
    
    static int Find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = Find(unf[v]);
    }
}

