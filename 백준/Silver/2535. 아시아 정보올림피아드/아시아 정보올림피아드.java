import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
    
    int country;
    int num;
    int grade;
    
    Person(int country, int num, int grade) {
        this.country = country;
        this.num = num;
        this.grade = grade;
    }
    
    public int compareTo(Person ob) {
        return ob.grade - this.grade;
    }
    
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] ch = new int[n+1];
        
        ArrayList<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            
            list.add(new Person(C, N, G));
        }
        
        Collections.sort(list);
        
        int cnt = 0;       
        
        for(int i=0; i<n; i++) {
            Person x = list.get(i);
            
            if(ch[x.country] < 2) {
                System.out.println(x.country + " " + x.num);
                ch[x.country]++;
                cnt++;
            }
            
            if(cnt == 3) return;
        }
        
    }
}

