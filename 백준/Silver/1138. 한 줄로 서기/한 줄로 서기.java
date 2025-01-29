import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=n; i>0; i--) {
            list.add(arr[i], i);
        }
        
        for(int x : list) System.out.print(x + " ");
    }
}

