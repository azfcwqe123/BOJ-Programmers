import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] stack;
    public static int size = 0;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        stack = new int[n];
        
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
                    
                case "top" :
                    sb.append(top()).append('\n');
                    break;
            }
            
        }
        
        System.out.print(sb);
        
    }
    
    //---
    
    public static void push(int item) {
        stack[size] = item;
        size++;
    }
    
    public static int pop() {
        
        if(size == 0) return -1;
        else {
            int tmp = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return tmp;
        }
    }
    
    public static int size() {
        return size;
    }
    
    public static int empty() {
        return size == 0 ? 1 : 0;
    }
    
    public static int top() {
        if(size == 0) return -1;
        else return stack[size - 1];
    }
    
}

