import java.util.*;
import java.io.*;

class Person {
    
    int kg;
    int cm;
    int grade = 1;
    
    Person(int kg, int cm) {
        this.kg = kg;
        this.cm = cm;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        Person[] arr = new Person[n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());
            
            arr[i] = new Person(kg, cm);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i].kg < arr[j].kg && arr[i].cm < arr[j].cm) arr[i].grade++;
            }
        }
        
        for(Person ob : arr) {
            System.out.print(ob.grade + " ");
        }
        
    }
    
}

