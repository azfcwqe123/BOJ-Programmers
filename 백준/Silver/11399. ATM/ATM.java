import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int tmp = 0, ans = 0;
        for(int i=0; i<n; i++) {
            tmp += arr[i];
            ans += tmp;
        }
        
        System.out.print(ans);
    }
    
}

