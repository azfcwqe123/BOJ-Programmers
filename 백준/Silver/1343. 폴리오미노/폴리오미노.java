import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        str = str.replaceAll("(" + "XXXX" + ")", "AAAA").replaceAll("(" + "XX" + ")", "BB");;
        
        if(str.contains("X")) System.out.print(-1);
        else System.out.print(str);
    }
    
}

