# [Silver IV] 차집합 - 1822 

[문제 링크](https://www.acmicpc.net/problem/1822) 

### 성능 요약

메모리: 267036 KB, 시간: 3348 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 정렬, 트리를 사용한 집합과 맵

### 제출 일자

2024년 12월 23일 18:43:46

### 문제 설명

<p>몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 집합 A의 원소의 개수 n(A)와 집합 B의 원소의 개수 n(B)가 빈 칸을 사이에 두고 주어진다. (1 ≤ n(A), n(B) ≤ 500,000)이 주어진다. 둘째 줄에는 집합 A의 원소가, 셋째 줄에는 집합 B의 원소가 빈 칸을 사이에 두고 주어진다. 하나의 집합의 원소는 2,147,483,647 이하의 자연수이며, 하나의 집합에 속하는 모든 원소의 값은 다르다.</p>

### 출력 

 <p>첫째 줄에 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수를 출력한다. 다음 줄에는 구체적인 원소를 빈 칸을 사이에 두고 증가하는 순서로 출력한다. 집합 A에는 속하면서 집합 B에는 속하지 않는 원소가 없다면 첫째 줄에 0만을 출력하면 된다.</p>

---

첫번째 풀이, 해시셋 2개 + 트리셋 1개

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) A.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) B.add(Integer.parseInt(st.nextToken()));
        
        TreeSet<Integer> list = new TreeSet<>();
        
        for(int x : A) {
            if(!B.contains(x)) list.add(x);   
        } 
        
        System.out.println(list.size());
        for(int x : list) System.out.print(x + " ");
        
    }
    
}


```

---

트리셋 1개

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) set.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) set.remove(Integer.parseInt(st.nextToken())); // 없는 키를 지우는게 가능하긴함. NullPointerException이 뜨지 않음
        
        StringBuilder sb = new StringBuilder();
        System.out.println(set.size());
        for(int x : set) sb.append(x + " ");
        
        System.out.print(sb);
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/712fd5aa-b4df-402c-9c96-df40159743db)
