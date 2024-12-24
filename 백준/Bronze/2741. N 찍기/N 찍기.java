import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        DFS(n);
    }
    
    public static void DFS(int n) {
        
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.println(n);
        }
        
    }
}

