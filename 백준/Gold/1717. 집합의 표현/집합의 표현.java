import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] unf;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        unf = new int[n+1];
        
        for(int i=0; i<=n; i++) unf[i] = i;
        
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int ch = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(ch == 0) Union(a, b);
            
            else {
                if(Find(a) == Find(b)) sb.append("YES");
                else sb.append("NO");
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        
        if(fa != fb) unf[fa] = fb;
    }
    
    static int Find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = Find(unf[v]);
    }
}