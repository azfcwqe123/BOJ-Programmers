import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] time = new int[100_001];
    static int[] parent = new int[100_001];
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        BFS();
        
        Stack<Integer> stack = new Stack<>();
        
        int idx = k;
        stack.push(k);
        
        while(idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        
        sb.append(time[k] - 1).append("\n");
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        
        System.out.print(sb);
    }
    
    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        time[n] = 1;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            
            if(cur == k) return;
            
            if(cur * 2 <= 100000 && time[cur * 2] == 0) {
                time[cur * 2] = time[cur] + 1;
                parent[cur * 2] = cur;
                Q.offer(cur * 2);
            }
            
            if(cur + 1 <= 100000 && time[cur + 1] == 0) {
                time[cur + 1] = time[cur] + 1;
                parent[cur + 1] = cur;
                Q.offer(cur + 1);
            }
            
            if(cur - 1 >= 0 && time[cur - 1] == 0) {
                time[cur - 1] = time[cur] + 1;
                parent[cur - 1] = cur;
                Q.offer(cur - 1);
            }
        }
        
    }
}

