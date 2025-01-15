import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int lower = Integer.parseInt(st.nextToken());
            int upper = Integer.parseInt(st.nextToken());
            
            sb.append(upperBound(upper) - lowerBound(lower) + 1);
            sb.append("\n");
        }
        
        System.out.print(sb);
        
    }
    
    // 자신보다 크거나 같은
    public static int lowerBound(int lower) {
        
        int lt = 0;
        int rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(arr[mid] < lower) lt = mid + 1;
            else rt = mid - 1;
        }
        
        return lt;
    }
    
    // 자신보다 작거나 같은
    public static int upperBound(int upper) {
        
        int lt = 0;
        int rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(upper < arr[mid]) rt = mid - 1;
            else lt = mid + 1;
        }
        
        return rt;
    }
}

