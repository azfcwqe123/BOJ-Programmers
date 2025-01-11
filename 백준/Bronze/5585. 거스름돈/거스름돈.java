import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int money = 1000 - n;
        
        int[] JPY = {500, 100, 50, 10, 5, 1};
        int ans = 0;
        
        for(int i=0; i<JPY.length; i++) {
            if(money / JPY[i] > 0) {
                ans += money / JPY[i];
                money -= (money / JPY[i]) * JPY[i];
            }
        }
        
        System.out.print(ans);
    }
    
}
