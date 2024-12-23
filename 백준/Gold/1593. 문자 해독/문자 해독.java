import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] ch1;
    public static int[] ch2;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        
        String W = br.readLine();
        String G = br.readLine();
        
        ch1 = new int[52];
        ch2 = new int[52];
        
        for(char x : W.toCharArray()) checkPlus(x, ch1);

        int ans = 0;
        
        for(int i=0; i<g; i++) {
            char tmp = G.charAt(i);
            
            checkPlus(tmp, ch2);
            
            if(i == w-1) {
                if(Arrays.equals(ch1, ch2)) ans++;
            }
            
            else if(i >= w) {
                checkMinus(G.charAt(i-w), ch2);
                if(Arrays.equals(ch1, ch2)) ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
    private static void checkPlus(char ch, int[] arr) {
        if(Character.isUpperCase(ch)) arr[ch-39]++;
        else arr[ch - 97]++;
    }
    
    private static void checkMinus(char ch, int[] arr) {
        if(Character.isUpperCase(ch)) arr[ch-39]--;
        else arr[ch - 97]--;
    }
    
}

