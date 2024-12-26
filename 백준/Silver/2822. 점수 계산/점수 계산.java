import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int[][] arr = new int[8][2];
        int[] ans = new int[5];
        
        for(int i=0; i<8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i+1;
        }
        
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        
        int sum = 0;
        
        for(int i=0; i<5; i++) {
            sum += arr[i][0];
            ans[i] = arr[i][1];
        }
        
        Arrays.sort(ans);
        
        System.out.println(sum);
        for(int x : ans) System.out.print(x + " ");
        
        
        
    }
}

