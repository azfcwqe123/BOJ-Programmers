# [Silver I] 1로 만들기 2 - 12852 

[문제 링크](https://www.acmicpc.net/problem/12852) 

### 성능 요약

메모리: 19672 KB, 시간: 136 ms

### 분류

다이나믹 프로그래밍, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 21일 17:51:10

### 문제 설명

<p>정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.</p>

<ol>
	<li>X가 3으로 나누어 떨어지면, 3으로 나눈다.</li>
	<li>X가 2로 나누어 떨어지면, 2로 나눈다.</li>
	<li>1을 뺀다.</li>
</ol>

<p>정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.</p>

### 입력 

 <p>첫째 줄에 1보다 크거나 같고, 10<sup>6</sup>보다 작거나 같은 자연수 N이 주어진다.</p>

### 출력 

 <p>첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.</p>

<p>둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.</p>

---

dp, 역추적

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        
        System.out.println(dp[n]);
        
        while(n > 0) {
            sb.append(n + " ");
            
            if(n == 1) break;
            
            if(n % 3 == 0 && dp[n / 3] == dp[n] - 1) n /= 3;
            else if(n % 2 == 0 && dp[n / 2] == dp[n] - 1) n /= 2;
            else n -= 1;
        }
        
        System.out.print(sb);
        
    }
}


```

---

풀이2

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        int[] trace = new int[n+1];
        
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            trace[i] = i - 1;
            
            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }
            if(i % 3 == 0 && dp[i / 3] + 1 < dp[i])  {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }
        }
        
        System.out.println(dp[n]);
        
        while(n > 0) {
            sb.append(n + " ");
            n = trace[n];
        }
        
        System.out.print(sb);
        
    }
}


```

---

![image](https://github.com/user-attachments/assets/d07a1ede-5f7f-4fa2-ada6-e82d0039f257)

참고 블로그 : 

https://141227.tistory.com/333

https://propercoding.tistory.com/392
