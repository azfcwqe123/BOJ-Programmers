import java.util.*;
import java.io.*;

class Main {
    
    static class Person implements Comparable<Person> {
        String name;
        int day;
        int month;
        int year;
        
        Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
        public int compareTo(Person ob) {
            if(this.year == ob.year) {
                if(this.month == ob.month) {
                    return ob.day - this.day;
                }
                return ob.month - this.month;
            }
            return ob.year - this.year;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Person> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new Person(name, day, month, year));
        }
        
        Collections.sort(list);
        
        System.out.print(list.get(0).name + "\n" + list.get(n-1).name);
    }
    
}

