# [Silver V] 나이순 정렬 - 10814 

[문제 링크](https://www.acmicpc.net/problem/10814) 

### 성능 요약

메모리: 52556 KB, 시간: 644 ms

### 분류

정렬

### 제출 일자

2024년 12월 23일 13:42:34

### 문제 설명

<p>온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)</p>

<p>둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.</p>

### 출력 

 <p>첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.</p>


---

객체 이용, 1216ms

```java
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


```

---

객체 이용, StringBuilder 추가 -> 644ms

```java
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
        
        StringBuilder sb = new StringBuilder();
        for(Person x : list) {
            sb.append(x.age + " " + x.name).append('\n');
        }
        
        System.out.print(sb);
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/df277415-d1ac-4dcf-a7f3-c876ed8316f7)
