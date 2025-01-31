# [Silver V] 돌 게임 - 9655 

[문제 링크](https://www.acmicpc.net/problem/9655) 

### 성능 요약

메모리: 14344 KB, 시간: 108 ms

### 분류

다이나믹 프로그래밍, 게임 이론, 수학

### 제출 일자

2025년 1월 31일 13:32:26

### 문제 설명

<p>돌 게임은 두 명이서 즐기는 재밌는 게임이다.</p>

<p>탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.</p>

<p>두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1000)</p>

### 출력 

 <p>상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.</p>

---

dp

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        
        for(int i=4; i<=1000; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-1]) + 1;
        }
        
        String ans = dp[n] % 2 == 0 ? "CY" : "SK"; // 짝수면 창영 WIN, 홀수면 상근 WIN
        
        System.out.print(ans);
    }
    
}


```

---

참고블로그: https://propercoding.tistory.com/21

![image](https://github.com/user-attachments/assets/bb322891-39fb-46e8-b35e-6ba1a4f5c657)
