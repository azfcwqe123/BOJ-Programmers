# [Silver V] 학생 인기도 측정 - 25325 

[문제 링크](https://www.acmicpc.net/problem/25325) 

### 성능 요약

메모리: 17132 KB, 시간: 160 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 정렬, 문자열, 트리를 사용한 집합과 맵

### 제출 일자

2024년 12월 18일 22:40:16

### 문제 설명

<p>학생 이름이 공백으로 구분된 문자열 <em>A</em>가 주어진다. 문자열 <em>A</em>에는 중복된 학생 이름이 존재하지 않는다. 학생 이름은 알파벳 소문자로 이루어져 있다. 각 학생이 좋아하는 학생의 학생 이름 목록이 공백으로 구분된 문자열로 주어진다. 각 학생이 좋아하는 학생은 1명 이상 주어지고, 내가 나를 좋아하는 예는 없다. 나를 좋아하는 학생이 많을수록 나의 인기도가 높다. 인기도가 높은 학생부터 낮은 학생 순으로 학생 이름과 해당 학생을 좋아하는 학생 수를 출력하자. 인기도가 같은 경우 학생 이름 기준으로 오름차순으로 출력하자.</p>

### 입력 

 <p>첫 번째 줄에 학생 수 <em>n</em>이 주어진다.</p>

<p>두 번째 줄에 <em>n</em>명의 학생 이름이 공백으로 구분된 문자열 <em>A</em>가 주어진다.</p>

<p>다음 줄부터 <em>n</em>개의 줄에 걸쳐 한 줄에 한 학생의 정보가 주어진다. 학생 정보는 문자열 <em>A</em>에 나온 학생 순서대로 주어진다. 한 명의 학생 정보는 해당 학생이 좋아하는 학생 이름이 공백으로 구분된 문자열로 주어진다.</p>

### 출력 

 <p>첫 번째 줄부터 <em>n</em>번째 줄까지 학생 이름과 해당 학생을 좋아하는 학생 수를 공백으로 구분하여 한 줄에 출력한다. 인기도가 높은 학생부터 낮은 학생 순으로 출력하고, 인기도가 같은 경우 학생 이름 기준으로 오름차순으로 출력한다.</p>

---

첫번째 풀이, Class + HashMap + ArrayList

```java
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


```

---

두번째 풀이, HashMap + ArrayList

```java
import java.util.*;
import java.io.*;

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
    
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b) -> {
            if(map.get(a) == map.get(b)) return a.compareTo(b);
            
            return map.get(b) - map.get(a);
        });
        
        for(String x : list) {
            sb.append(x + " " + map.get(x)).append("\n");
        }
        
        System.out.print(sb);
    }
    
}


```

---

세번째 풀이, 배열리스트 정렬 부분을 삼항연산자 사용해서 더 깔끔하게 함

```java
import java.util.*;
import java.io.*;

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
    
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b) -> {
            return map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a); // 여기 수정
        });
        
        for(String x : list) {
            sb.append(x + " " + map.get(x)).append("\n");
        }
        
        System.out.print(sb);
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/6f66b1f8-4076-4170-bac2-8ad0690f4b86)
