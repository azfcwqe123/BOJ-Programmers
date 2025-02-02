import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static boolean[] visited = new boolean[100_001];
    
    static class Point {
        int pos;
        int time;
        
        Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int ans = BFS();
        
        System.out.print(ans);
    }
    
    static int BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(N, 0));
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Point cur = Q.poll();
                visited[cur.pos] = true;
                
                if(cur.pos == K) return cur.time;
                
                int[] move = {cur.pos * 2, cur.pos - 1, cur.pos + 1};
                
                for(int d=0; d<move.length; d++) {
                    
                    if(!rangeCheck(move[d]) || visited[move[d]]) continue;
                    
                    if(d==0) Q.offer(new Point(move[d], cur.time));
                    else Q.offer(new Point(move[d], cur.time + 1));
                }
                
            }
        }
        
        return -1;
    } 
    
    static boolean rangeCheck(int pos) {
        return pos >= 0 && pos < 100_001;
    }
}

