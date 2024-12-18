import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        char game = st.nextToken().charAt(0);
        
        HashSet<String> set = new HashSet<>();
        
        while(n-- > 0) {
            set.add(br.readLine());
        }
        
        if(game == 'Y') System.out.print(set.size());
        
        else if(game == 'F') System.out.print(set.size() / 2);
        
        else if(game == 'O') System.out.print(set.size() / 3);
    }
    
}

