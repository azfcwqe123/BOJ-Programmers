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
        
        int pack = 1001, each = 1001;
        
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            each = Math.min(each, Integer.parseInt(st.nextToken()));
        }
        
        int ans = 0;
        
        ans = Math.min((n / 6 + 1) * pack, n * each); // 패키지 구매 vs 낱개 구매 
        
        ans = Math.min((n / 6) * pack + (n % 6) * each, ans); // 혼합 구매 vs (패키지 구매 or 낱개 구매)
        
        System.out.print(ans);
    }
    
}

