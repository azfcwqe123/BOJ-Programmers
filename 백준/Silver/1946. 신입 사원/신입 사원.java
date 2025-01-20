import java.util.*;
import java.io.*;

class Main {
    
    static class Person {
        int G;
        int I;
        
        Person(int G, int I) {
            this.G = G;
            this.I = I;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            ArrayList<Person> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int G = Integer.parseInt(st.nextToken());
                int I = Integer.parseInt(st.nextToken());
                list.add(new Person(G, I));
            }
            
            Collections.sort(list, (a, b) -> a.G - b.G);
            
            int ans = 1, min = list.get(0).I;
            
            for(int i=1; i<n; i++) {
                if(list.get(i).I < min) {
                    min = list.get(i).I;
                    ans++;
                }
            }
            
            sb.append(ans).append('\n');
        }
        
        System.out.print(sb);
    }
    
}

