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
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        long lt = 1;
        long rt = arr[n-1];
        long cnt, mid;
        
        while(lt <= rt) {
            cnt = 0;
            mid = (lt + rt) / 2;
            
            for(int i=0; i<n; i++) cnt += arr[i] / mid;
            
            if(cnt < m) rt = mid - 1;
            else lt = mid + 1;
        }
        
        System.out.print(rt);

    }
}

