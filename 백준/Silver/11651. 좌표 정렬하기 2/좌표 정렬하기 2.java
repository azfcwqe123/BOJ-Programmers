import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][2];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        
        for(int[] xy : arr) System.out.println(xy[0] + " " + xy[1]);
    }
    
}

