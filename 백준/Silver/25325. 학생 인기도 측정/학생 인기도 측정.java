import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    String name;
    int count;
    
    Student(String name, int count) {
        this.name = name;
        this.count = count;
    }
    
    @Override
    public int compareTo(Student o) {
        if(this.count == o.count) return this.name.compareTo(o.name);
        else return o.count - this.count;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) map.put(st.nextToken(), 0);
        
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                String tmp = st.nextToken();
                map.put(tmp, map.get(tmp) + 1);
            }
        }
    
        ArrayList<Student> list = new ArrayList<>();
        
        for(String key : map.keySet()) {
            list.add(new Student(key, map.get(key)));    
        }
        
        Collections.sort(list);
        
        for(Student x : list) sb.append(x.name + " " + x.count).append("\n");
        
        System.out.print(sb);
    }
    
}

