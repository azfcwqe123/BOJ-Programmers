# [Silver III] 소수 구하기 - 1929 

[문제 링크](https://www.acmicpc.net/problem/1929) 

### 성능 요약

메모리: 29532 KB, 시간: 616 ms

### 분류

수학, 정수론, 소수 판정, 에라토스테네스의 체

### 제출 일자

2025년 1월 2일 18:11:01

### 문제 설명

<p>M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.</p>

### 출력 

 <p>한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.</p>

---

에라토스테네스의 체 이용

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static boolean[] isPrime;
    public static int m;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        isPrime = new boolean[m + 1];
        Arrays.fill(isPrime, true);
        
        Check();
        
        for(int i=n; i<=m; i++) {
            if(isPrime[i]) System.out.println(i);
        }
        
    }
    
    public static void Check() {
        
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2; i<=Math.sqrt(m); i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=m; j+=i) {
                isPrime[j] = false;
            }
        }
        
    }
    
}


```

---

시간 초과 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=n; i<=m; i++) {
            if(Check(i)) System.out.println(i);
        }
        
    }
    
    public static boolean Check(int k) {
        
        if(k==0 || k==1) return false;
        
        for(int i=2; i<k; i++) {
            if(k % i == 0) return false;
        }
        
        return true;
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/c54b16ad-d6f9-497a-86b4-88ffb543b297)
