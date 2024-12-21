import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int L = str.length();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=1; i<L-1; i++) {
            
            for(int j=i+1; j<L; j++) {
                
                String a = new StringBuilder(str.substring(0, i)).reverse().toString();
                String b = new StringBuilder(str.substring(i, j)).reverse().toString();
                String c = new StringBuilder(str.substring(j, L)).reverse().toString();
                
                list.add(a + b + c);
                
            }
        }
        
        list.sort((a,b) -> a.compareTo(b));
        
        System.out.print(list.get(0));
        
    }
}



