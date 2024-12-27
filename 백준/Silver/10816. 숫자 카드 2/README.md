# [Silver IV] 숫자 카드 2 - 10816 

[문제 링크](https://www.acmicpc.net/problem/10816) 

### 성능 요약

메모리: 190228 KB, 시간: 1084 ms

### 분류

이분 탐색, 자료 구조, 해시를 사용한 집합과 맵, 정렬

### 제출 일자

2024년 12월 27일 18:11:01

### 문제 설명

<p>숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.</p>

<p>셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.</p>

---

해시맵

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(st.nextToken());
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int ch = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(ch)) sb.append(map.get(ch) + " ");
            else sb.append("0 ");
        }
        
        System.out.print(sb);
    }
    
}


```

---

이분 탐색

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int key = Integer.parseInt(st.nextToken());
            
            sb.append(upperBound(arr, key) - lowerBound(arr, key) + " ");
        }
        
        System.out.print(sb);
        
    }
    
    private static int lowerBound(int[] arr, int key) {
        
        int lt = 0, rt = arr.length;
        
        while(lt < rt) {
            
            int mid = (lt + rt) / 2;
            
            if(key <= arr[mid]) {
                rt = mid;
            }
            
            else lt = mid + 1;
        }
        
        return lt;
        
    }
    
    private static int upperBound(int[] arr, int key) {
        
        int lt = 0, rt = arr.length;
        
        while(lt < rt) {
            
            int mid = (lt + rt) / 2;
            
            if(key < arr[mid]) {
                rt = mid;
            }
            
            else lt  = mid + 1;
        }
        
        return rt;
    }
    
}


```

---

직접 구현, 테스트케이스는 맞으나, 메모리 초과뜸

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[200_000_001];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[Integer.parseInt(st.nextToken()) + 100_000_000]++;
        }
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 100_000_000] + " ");
        }
        
        System.out.print(sb);
        
    }
    
}


```

---

참고 블로그 : https://st-lab.tistory.com/267

![image](https://github.com/user-attachments/assets/53ea4561-5268-45c5-a732-350246aefd8a)

밑에서부터 해시맵, 이분탐색, 직접구현이다.
