import java.util.*;
import java.io.*;

class Docu {
    int priority;
    int order;
    
    Docu(int priority, int order) {
        this.priority = priority;
        this.order = order;
    }
}
class Main {
    
    //private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T-- > 0) {
            
            LinkedList<Docu> Q = new LinkedList<>();
            
            int N = sc.nextInt();
            int M = sc.nextInt(); // 찾아야할 순서
            
            for(int i=0; i<N; i++) {
                Q.offer(new Docu(sc.nextInt(), i));
            }
            
            int cnt = 0;
            
            while(!Q.isEmpty()) {
                Docu tmp = Q.poll();
                boolean isMax = true;
                
                for(int i=0; i<Q.size(); i++) {
                    
                    if(tmp.priority < Q.get(i).priority) {
                        
                        Q.offer(tmp);
                        for(int j=0; j<i; j++) {
                            Q.offer(Q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                
                if(!isMax) continue;
                
                cnt++;
                
                if(tmp.order == M) break;
                
                
            }
            
            System.out.println(cnt);
        }
        

        
    }
    
}
    


