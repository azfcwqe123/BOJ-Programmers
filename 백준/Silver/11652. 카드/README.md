# [Silver IV] 카드 - 11652 

[문제 링크](https://www.acmicpc.net/problem/11652) 

### 성능 요약

메모리: 38692 KB, 시간: 332 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 정렬

### 제출 일자

2024년 12월 28일 18:34:31

### 문제 설명

<p>준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -2<sup>62</sup>보다 크거나 같고, 2<sup>62</sup>보다 작거나 같다.</p>

<p>준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.</p>

### 입력 

 <p>첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.</p>

### 출력 

 <p>첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.</p>

---

첫번째 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Long, Integer> map = new HashMap<>();
        
        while(n-- > 0) {
            long k = Long.parseLong(br.readLine());
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int max = 0;
        
        for(int x : map.values()) {
            max = Math.max(x, max);    
        }
        
        ArrayList<Long> list = new ArrayList<>();
        
        for(Long key : map.keySet()) {
            if(map.get(key) == max) list.add(key);
        }
        
        Collections.sort(list);
        
        System.out.print(list.get(0));

    }
    
}
    



```

---

두번째 풀이, 리팩토링, 참고함

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Long, Integer> map = new HashMap<>();
        
        while(n-- > 0) {
            long k = Long.parseLong(br.readLine());
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int max = 0;
        long ans = 0;
        
        for(long key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                ans = key;
            }
            
            else if(map.get(key) == max) {
                ans = Math.min(key, ans);
            }
        }
        
        System.out.print(ans);

    }
    
}
    



```

---

![image](https://github.com/user-attachments/assets/4ed24716-1dab-4767-9706-bfcfe652b8f9)
