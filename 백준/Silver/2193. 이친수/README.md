# [Silver III] 이친수 - 2193 

[문제 링크](https://www.acmicpc.net/problem/2193) 

### 성능 요약

메모리: 14252 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 9일 17:02:00

### 문제 설명

<p>0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.</p>

<ol>
	<li>이친수는 0으로 시작하지 않는다.</li>
	<li>이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.</li>
</ol>

<p>예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.</p>

<p>N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다.</p>

### 출력 

 <p>첫째 줄에 N자리 이친수의 개수를 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int mod = 10007;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        long[] dp = new long[91];
        
        dp[1] = 1;
        dp[2] = 1;
        
        // dp[i-2] 숫자 목록 모두에 00을 붙인다.
        
        // dp[i-1] 숫자 목록 중에 0으로 끝나는 숫자는 1을 붙이고
        // 1로 끝나는 숫자에는 0을 붙인다.
        
        // 규칙 발견
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.out.print(dp[n]);
    }
}

```
n=1 -> {1}

n=2 -> {10}

n=3 -> {100, 101}

n=4 -> {1000, 1001, 1010}

...

---

long형 범위를 쓰지 않아서 틀렸음

![image](https://github.com/user-attachments/assets/bf707a43-a4a1-4286-b08a-9f0e8df2fad3)
