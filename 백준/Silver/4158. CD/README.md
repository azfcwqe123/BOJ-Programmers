# [Silver V] CD - 4158 

[문제 링크](https://www.acmicpc.net/problem/4158) 

### 성능 요약
 
메모리: 277364 KB, 시간: 864 ms

### 분류

이분 탐색, 자료 구조, 해시를 사용한 집합과 맵, 두 포인터

### 제출 일자

2024년 12월 19일 17:21:17

### 문제 설명

<p>상근이와 선영이는 동시에 가지고 있는 CD를 팔려고 한다. CD를 몇 개나 팔 수 있을까?</p>

### 입력 

 <p>입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 상근이가 가지고 있는 CD의 수 N, 선영이가 가지고 있는 CD의 수 M이 주어진다. N과 M은 최대 백만이다. 다음 줄부터 N개 줄에는 상근이가 가지고 있는 CD의 번호가 오름차순으로 주어진다. 다음 M개 줄에는 선영이가 가지고 있는 CD의 번호가 오름차순으로 주어진다. CD의 번호는 십억을 넘지 않는 양의 정수이다. 입력의 마지막 줄에는 0 0이 주어진다.</p>

<p>상근이와 선영이가 같은 CD를 여러장 가지고 있는 경우는 없다.</p>

### 출력 

 <p>두 사람이 동시에 가지고 있는 CD의 개수를 출력한다.</p>

---

해시맵 풀이(2004ms)

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            
            while(n-- > 0) {
                int k = Integer.parseInt(br.readLine());
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        
            while(m-- > 0) {
                int k = Integer.parseInt(br.readLine());
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            
            for(int key : map.keySet()) {
                if(map.get(key) > 1) ans++;
            }
        
            System.out.println(ans);
        }
        
        
    }
    
}


```

---

해시셋 풀이(1112ms)

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            int ans = 0;
            HashSet<Integer> set = new HashSet<>();
            
            while(n-- > 0) set.add(Integer.parseInt(br.readLine()));
        
            while(m-- > 0) {
                int k = Integer.parseInt(br.readLine());
                if(set.contains(k)) ans++;
                else set.add(k);
            }
            
            System.out.println(ans);
            
        }
        
        
    }
    
}


```

---

투포인터 풀이(864ms)

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            
            for(int i=0; i<n; i++) arr1[i] = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++) arr2[i] = Integer.parseInt(br.readLine());
            
            int lt = 0, rt = 0;
            
            int ans = 0;
            
            while(lt < n && rt < m) {
                
                if(arr1[lt] == arr2[rt]) {
                    ans++;
                    lt++;
                    rt++;
                }
                
                else if(arr1[lt] < arr2[rt]) lt++;
                
                else if(arr1[lt] > arr2[rt]) rt++;
                
            }
            
            System.out.println(ans);
            
        }
        
        
    }
    
}


```

![image](https://github.com/user-attachments/assets/0b57088d-d170-4964-95a8-2cf109ce0af9)
