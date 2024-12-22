import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<m; i++) {
            
            int k = Integer.parseInt(br.readLine());
            
            int[] books = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
            
            for(int j=0; j<k-1; j++) {
                if(books[j] < books[j+1]) {
                    System.out.print("No");
                    return;
                }
            }
        }
        
        System.out.print("Yes");
        
    }
    
}

