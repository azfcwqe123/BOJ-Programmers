import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    static class Meet implements Comparable<Meet> {
        int st;
        int ed;
        
        Meet(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }
        
        public int compareTo(Meet ob) {
            if(this.ed == ob.ed) return this.st - ob.st;
            return this.ed - ob.ed;
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Meet> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Meet(s, e));    
        }
        
        Collections.sort(list);
        
        int cnt = 0, prev_time = 0;
        
        for(int i=0; i<n; i++) {
            
            if(prev_time <= list.get(i).st) {
                prev_time = list.get(i).ed;
                cnt++;
            }
        }
        
        System.out.print(cnt);
    }
    
}

