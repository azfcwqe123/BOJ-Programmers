# [Silver III] 2×n 타일링 2 - 11727 

[문제 링크](https://www.acmicpc.net/problem/11727) 

### 성능 요약

메모리: 14376 KB, 시간: 92 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 1월 18일 20:25:57

### 문제 설명

<p>2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.</p>

<p>아래 그림은 2×17 직사각형을 채운 한가지 예이다.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/t2n2122.gif" style="height:59px; width:380px"></p>

### 입력 

 <p>첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.</p>

---

dp 기초, 규칙만 찾으면 쉽게 풀 수 있음

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i=3; i<=n; i++) dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
        
        System.out.print(dp[n]);
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/73c4b8cc-db0c-4b74-92f0-bb29cd486893)
