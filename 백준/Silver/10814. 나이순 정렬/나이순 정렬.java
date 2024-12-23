import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
    int age;
    String name;
    
    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    @Override
    public int compareTo(Person ob) {
        return this.age - ob.age;
    }
    
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Person> list = new ArrayList<>();
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            list.add(new Person(age, name));
        }
        
        Collections.sort(list);
        
        for(Person x : list) {
            System.out.println(x.age + " " + x.name);
        }
        
    }
    
}

