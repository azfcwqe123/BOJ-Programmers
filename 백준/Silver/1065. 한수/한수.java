import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        for(int i=1; i<=n; i++) {
            if(i < 10) ans++;
            else if(check(String.valueOf(i))) ans++;
        }
        
        System.out.print(ans);
    }
    
    static boolean check(String tmp) {
        
        char[] arr = tmp.toCharArray();
        
        int a = arr[0];
        int d = (arr[1] - '0') - (arr[0] - '0');
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != a + d * i) return false;
        }
        
        return true;
    }
    
}


