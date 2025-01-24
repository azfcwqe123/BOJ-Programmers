import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            Deque<Integer> deque = new LinkedList<>();
            
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            String str = br.readLine();
            for(String s : str.substring(1, str.length() - 1).split(",")) {
                if(!s.equals("")) deque.add(Integer.valueOf(s));
            }
            
            sb.append(solution(deque, func)).append('\n');
            
        }
        
        System.out.print(sb);
        
    }
    
    static String solution(Deque<Integer> deque, String func) {
        
        boolean reverse = false;
        
        for(char x : func.toCharArray()) {
            
            if(x == 'R') reverse = !reverse;
            
            else if(x == 'D') {
                
                if(deque.size() == 0) return "error";
                
                if(reverse) deque.removeLast();
                
                else deque.removeFirst();
            }
        }
        
        StringBuilder tmp = new StringBuilder("[");
        
        while(!deque.isEmpty()) {
            tmp.append(reverse ? deque.removeLast() : deque.removeFirst());
            
            if(deque.size() != 0) tmp.append(",");
        }
        
        tmp.append("]");
        
        return tmp.toString();
    }
    
}
