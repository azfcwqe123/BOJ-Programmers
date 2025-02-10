import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        Deque deque = new Deque();
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            String ch = st.nextToken();
            
            if(ch.equals("push_front")) {
                deque.push_front(Integer.parseInt(st.nextToken()));
            }
            
            else if(ch.equals("push_back")) {
                deque.push_back(Integer.parseInt(st.nextToken()));
            }
            
            else if(ch.equals("pop_front")) sb.append(deque.pop_front() + "\n");
            else if(ch.equals("pop_back")) sb.append(deque.pop_back() + "\n");
            else if(ch.equals("size")) sb.append(deque.size() + "\n");
            else if(ch.equals("empty")) sb.append(deque.empty() + "\n");
            else if(ch.equals("front")) sb.append(deque.front() + "\n");
            else if(ch.equals("back")) sb.append(deque.back() + "\n");
        }
        
        System.out.print(sb);
        
    }
    
}

class Deque {
    
    int[] arr = new int[20001];
    int front = 10000, back = 10001, size = 0;
    
    void push_front(int x) {
        arr[front--] = x;
        size++;
    }
    
    void push_back(int x) {
        arr[back++] = x;
        size++;
    }
    
    int pop_front() {
        if(size == 0) return -1;
        size--;
        return arr[++front];
    }
    
    int pop_back() {
        if(size == 0) return -1;
        size--;
        return arr[--back];
    }
    
    int size() {
        return size;
    }
    
    int empty() {
        return size == 0 ? 1 : 0;
    }
    
    int front() {
        return size == 0 ? -1 : arr[front + 1];
    }
    
    int back() {
        return size == 0 ? -1 : arr[back - 1];
    }
    
}

