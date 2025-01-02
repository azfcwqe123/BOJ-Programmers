import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static boolean[] isPrime;
    public static int m;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        isPrime = new boolean[m + 1];
        Arrays.fill(isPrime, true);
        
        Check();
        
        for(int i=n; i<=m; i++) {
            if(isPrime[i]) sb.append(i + "\n");
        }
        
        System.out.print(sb);
        
    }
    
    public static void Check() {
        
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2; i<=Math.sqrt(m); i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=m; j+=i) {
                isPrime[j] = false;
            }
        }
        
    }
    
}

