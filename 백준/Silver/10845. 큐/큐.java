import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] Q = new int[10001];
    public static int first = 0, last = 0;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        Q = new int[n];
        
        while(n-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()) {
                
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                
                case "pop" :
                    sb.append(pop()).append('\n');
                    break;
                    
                case "size" :
                    sb.append(size()).append('\n');
                    break;
                    
                case "empty" :
                    sb.append(empty()).append('\n');
                    break;
                
                case "front" :
                    sb.append(front()).append('\n');
                    break;
                
                case "back" :
                    sb.append(back()).append('\n');
                    break;
            }
            
        }
        
        System.out.print(sb);
        
    }
    
    //---
    
    public static void push(int item) {
        Q[last++] = item;
    }
    
    public static int pop() {
        if(last - first == 0) return -1;
        else {
            int tmp = Q[first++];
            return tmp;
        }
    }
    
    public static int size() {
        return last - first;
    }
    
    public static int empty() {
        if(last - first == 0) return 1;
        else return 0;
    }
    
    public static int front() {
        if(last - first == 0) return -1;
        else {
            int tmp = Q[first];
            return tmp;
        }
    }
    
    public static int back() {
        if(last - first == 0) return -1;
        else {
            int tmp = Q[last - 1];
            return tmp;
        }
    }
    
}

