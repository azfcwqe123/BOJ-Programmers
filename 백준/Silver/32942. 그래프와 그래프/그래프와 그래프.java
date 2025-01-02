import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=10; i++) graph.add(new ArrayList<>());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=10; j++) {
                if(a*i + b*j == c) graph.get(i).add(j);
            }
        }
        
        for(int i=1; i<=10; i++) {
            if(graph.get(i).size() == 0) System.out.println(0);
            else {
                for(int j=0; j<graph.get(i).size(); j++) {
                    System.out.print(graph.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
        
    }
    
}

