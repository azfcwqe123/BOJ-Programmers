import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int[] arr = new int[10]; // 0 ~ 9
        
        for(char x : str.toCharArray()) {
            arr[x - '0']++;
        }
        
        int ans = 0;
        
        while(true) {
            
            boolean check = false;
            
            for(int i=0; i<10; i++) {
                if(arr[i] == 0) {
                    if(i==6 && arr[9] != 0) {
                        arr[9]--;
                        check = true;
                    }
                    if(i==9 && arr[6] != 0) {
                        arr[6]--;
                        check = true;
                    }
                    else continue;
                }
                else {
                    arr[i]--;
                    check = true;
                }
            }
            
            if(!check) break;
            
            ans++;
        }
        
        System.out.print(ans);
    }
    
}

