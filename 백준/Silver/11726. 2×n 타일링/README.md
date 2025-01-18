# [Silver III] 2×n 타일링 - 11726 

[문제 링크](https://www.acmicpc.net/problem/11726) 

### 성능 요약

메모리: 14304 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 1월 18일 20:08:37

### 문제 설명

<p>2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.</p>

<p>아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png" style="height:50px; width:125px"></p>

### 입력 

 <p>첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.</p>

---

dp 기초

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001]; // 런타임 에러 났던 이유 -> int[] dp = new int[n+1]로 했었는데, n=1이면 dp[2]=2가 성립 자체를 못함.
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++) dp[i] = (dp[i-2] + dp[i-1]) % 10007; // 10007로 나눠줘야 오버플로우 발생 x
        
        System.out.print(dp[n]);
    }
    
}


```

1x2 타일을 dp[i-1] 왼쪽 타일들에 붙이고, 2x1 타일을 dp[i-2] 타일들에 붙이면 규칙 완성

---

![image](https://github.com/user-attachments/assets/ac30fbae-9c63-437e-a350-a08e971976f1)

![image](https://github.com/user-attachments/assets/afe1d3a8-288d-491b-8c92-e84057291837)

