# [Silver I] 포도주 시식 - 2156 

[문제 링크](https://www.acmicpc.net/problem/2156) 

### 성능 요약

메모리: 14920 KB, 시간: 124 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 11일 19:48:26

### 문제 설명

<p>효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.</p>

<ol>
	<li>포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.</li>
	<li>연속으로 놓여 있는 3잔을 모두 마실 수는 없다.</li>
</ol>

<p>효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. </p>

<p>예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.</p>

### 입력 

 <p>첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.</p>

### 출력 

 <p>첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.</p>

---

DP

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] wine = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) wine[i] = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++) {
            
            if(i==1) dp[i] = wine[i]; // 잔이 1개만 있을때
            else if(i==2) dp[i] = wine[i] + wine[i-1]; // 잔이 2개만 있을때
            else dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
            // dp[i-1] : i번째 잔 안 마심
            // dp[i-2] + wine[i] : i-1번째 잔을 안 마시고, i번째 잔을 마시는 경우
            // dp[i-3] + wine[i-1] + wine[i] : i-2번째 잔을 안 마시고, i-1번째, i번째 잔을 마시는 경우
        }
        
        System.out.println(dp[n]);
    }
    
}


```

---

![1Be2NrRGAPf7V1qMjeQL1x_250311_200324](https://github.com/user-attachments/assets/0bd25e37-f8ed-4d17-95ad-bf6d5fe6077c)


![image](https://github.com/user-attachments/assets/d0503a52-4bb4-4079-b765-12b742430b53)


