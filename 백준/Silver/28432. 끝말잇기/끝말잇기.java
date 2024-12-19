import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    private static String[] arr;
    
    public static void main(String[] args) throws IOException {
        
        HashSet<String> set = new HashSet<>();
        
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];

        int index = 0;
        
        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            
            if(!tmp.equals("?")) set.add(tmp);
            else index = i;
            
            arr[i] = tmp;
        }
        
        int m = Integer.parseInt(br.readLine());
        
        int lt = index - 1;
        int rt = index + 1;
            
        while(m-- > 0) {
            
            String word = br.readLine();
            if(set.contains(word)) continue;
            
            int len = word.length();
            
            if(n == 1) {
                System.out.print(word);
                return;
            }
            
            if(lt < 0) {
                char ch1 = word.charAt(len - 1);
                char ch2 = arr[rt].charAt(0);
                if(ch1 == ch2) {
                    System.out.print(word);
                    return;
                }
            }
            
            else if(rt >= n) {
                char ch1 = arr[lt].charAt(arr[lt].length() - 1);
                char ch2 = word.charAt(0);
                
                if(ch1 == ch2) {
                    System.out.print(word);
                    return;
                }
            }
            
            else {
                char ch1 = arr[lt].charAt(arr[lt].length() - 1);
                char ch2 = arr[rt].charAt(0);
                
                char a = word.charAt(0);
                char b = word.charAt(len - 1);
                
                if(ch1 == a && ch2 == b) {
                    System.out.print(word);
                    return;
                }
            }
        
        }
        
    }
}

