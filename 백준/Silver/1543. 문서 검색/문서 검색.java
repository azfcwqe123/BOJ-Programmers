import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        String docu = br.readLine();
        String k = br.readLine();
        
        String tmp = docu.replaceAll("(" + k + ")", "");
        
        System.out.print((docu.length() - tmp.length()) / k.length()); 
        
    }
}


