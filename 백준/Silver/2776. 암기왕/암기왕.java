import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0 ) {
            StringBuilder sb = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(arr);
            
            int M = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                int k = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(arr, k)).append('\n');    
            }
            
            System.out.print(sb);
        }
        
    }
    
    public static int binarySearch(int[] arr, int k) {
        
        int lt = 0;
        int rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(k < arr[mid]) rt = mid - 1;
            else if(k > arr[mid]) lt = mid + 1;
            else return 1;
            
        }
        
        return 0;
        
    }
}

