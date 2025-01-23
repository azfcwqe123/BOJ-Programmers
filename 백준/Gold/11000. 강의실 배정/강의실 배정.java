import java.util.*;
import java.io.*;

class Time implements Comparable<Time>{
    int st;
    int ed;
    
    Time(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }
    
    public int compareTo(Time ob) {
        if(this.st == ob.st) return this.ed - ob.ed;
        else return this.st - ob.st;
    }
}

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Time> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.add(new Time(a, b));
        }
        
        Collections.sort(list);
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add(list.get(0).ed);
        
        for(int i=1; i<n; i++) {
            
            if(pQ.peek() <= list.get(i).st) {
                pQ.poll();
            }
            
            pQ.add(list.get(i).ed);
        }
        
        System.out.print(pQ.size());
        
    }
    
}

