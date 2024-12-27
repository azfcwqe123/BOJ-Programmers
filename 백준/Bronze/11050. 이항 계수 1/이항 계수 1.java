import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.print(combi(N, K));
        
    }
    
    private static int combi(int N, int K) {
        if(N==K || K==0) return 1;
        else return combi(N-1, K-1) + combi(N-1, K);
    }
    
}

