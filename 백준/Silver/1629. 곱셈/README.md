# [Silver I] 곱셈 - 1629 

[문제 링크](https://www.acmicpc.net/problem/1629) 

### 성능 요약

메모리: 14264 KB, 시간: 104 ms

### 분류

분할 정복을 이용한 거듭제곱, 수학

### 제출 일자

2025년 3월 2일 17:07:59

### 문제 설명

<p>자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.</p>

### 출력 

 <p>첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.</p>

---

분할정복, 재귀, O(logN)

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        System.out.print(dfs(a, b, m));
    }
    
    public static long dfs(int a, int b, int mod) {
        
        if(b==0) return 1;
        long n = dfs(a, b/2, mod);
        if(b % 2 == 0) return n * n % mod;
        else return (n * n % mod) * a % mod;
    }
}
```

---

틀린 풀이(메모리 초과), O(N)

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int sum = 0, A, B, C;
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        dfs(B);
    }
    
    public static void dfs(int n) {
        
        if(n==0) {
            System.out.print(A);
            return;
        }
        
        A *= A;
        A %= C;
        dfs(n-1);
    }
}
```

---

https://st-lab.tistory.com/237

![image](https://github.com/user-attachments/assets/52dcca65-a305-4566-bbfc-9e1c556761bc)

