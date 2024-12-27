import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        
        int[] size = new int[6];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) size[i] = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<6; i++) {
            cnt += size[i] / T;
            if(size[i] % T > 0) cnt += 1;
        }
        
        System.out.println(cnt);
        System.out.println(N/P + " " + N%P);
        
        
    }
    
}

