# [Silver I] 쉬운 계단 수 - 10844 

[문제 링크](https://www.acmicpc.net/problem/10844) 

### 성능 요약

메모리: 14200 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 9일 15:19:42

### 문제 설명

<p>45656이란 수를 보자.</p>

<p>이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.</p>

<p>N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.</p>

---

DP

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int mod = 1000000000;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        // row는 자리수, column은 시작수
        int[][] dp = new int[n+1][10];
        
        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }
        
        // 규칙을 찾아 배열에 대입
        for(int i=2; i<=n; i++) {
            
            for(int j=0; j<=9; j++) {
                // 0으로 시작하는 수는 계산에 불필요하지만, 규칙을 찾는데에는 필요함.
                if(j == 0) dp[i][0] = dp[i-1][1] % mod;
                
                // 시작수가 9일때
                else if(j == 9) dp[i][9] = dp[i-1][8] % mod;
                
                // 시작수가 2~8일때
                else dp[i][j] = (dp[i-1][j-1] % mod + dp[i-1][j+1] % mod) % mod;
            }
        }
        
        
        int ans = 0;
        for(int i=1; i<=9; i++) {
            ans += dp[n][i];
            ans %= mod; // 오버플로우 방지
        }
        
        System.out.print(ans);
    }
    
}


```

---

참고블로그 : https://yinq.tistory.com/72

![image](https://github.com/user-attachments/assets/860b2e0b-5131-4855-a0de-f94f9ef3761e)
