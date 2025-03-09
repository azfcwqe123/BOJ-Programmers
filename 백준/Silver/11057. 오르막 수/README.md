# [Silver I] 오르막 수 - 11057 

[문제 링크](https://www.acmicpc.net/problem/11057) 

### 성능 요약

메모리: 14240 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 9일 16:18:41

### 문제 설명

<p>오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.</p>

<p>예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.</p>

<p>수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.</p>

### 입력 

 <p>첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.</p>

### 출력 

 <p>첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.</p>

---

DP

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
        
        // row는 자리수, column은 시작수
        int[][] dp = new int[n+1][10];
        
        for(int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=2; i<=n; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=j; k<=9; k++) {
                    dp[i][j] += dp[i-1][k] % mod;
                }
            }
        }   
        
        int ans = 0;
        for(int i=0; i<=9; i++) {
            ans += dp[n][i];
            ans %= mod;
        }
        
        System.out.print(ans);
        
    }
}

```

---

![image](https://github.com/user-attachments/assets/485f0a62-60e9-4400-873b-4ea6d3197153)

