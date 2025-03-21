import java.util.*;
import java.io.*;

class Main {
    
    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;
        
        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        
        @Override
        public int compareTo(Student ob) {
            if(this.kor == ob.kor) {
                if(this.eng == ob.eng) {
                    if(this.math == ob.math) {
                        return this.name.compareTo(ob.name);
                    }
                    return ob.math - this.math;
                }
                return this.eng - ob.eng;
            }
            return ob.kor - this.kor;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        ArrayList<Student> list = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            
            list.add(new Student(name, kor, eng, math));
        }
        
        Collections.sort(list);
        
        for(Student x : list) {
            sb.append(x.name + "\n");
        }
        
        System.out.print(sb);
    }
    
}

