import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(char x : str.toCharArray()) list.add(x - '0');
        
        list.sort((a,b) -> b - a);
        
        for(int x : list) System.out.print(x); 
        
    }
}



