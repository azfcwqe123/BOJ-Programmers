import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        System.out.print(dfs(a, b, m));
    }
    
    public static long dfs(int a, int b, int mod) {
        
        if(b==0) return 1;
        long n = dfs(a, b/2, mod);
        if(b % 2 == 0) return n * n % mod;
        else return (n * n % mod) * a % mod;
    }
}