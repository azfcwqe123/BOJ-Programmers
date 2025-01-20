import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        char[] arr = br.readLine().toCharArray();
        
        Arrays.sort(arr);
        
        int sum = 0;
        for(int i = arr.length-1; i>=0; i--) {
            sum += arr[i] - '0';
            sb.append(arr[i]);
        }
        
        if(sum % 3 == 0 && arr[0] == '0') {
            System.out.print(sb);
            return;
        }
        
        System.out.print(-1);
    }
    
}

