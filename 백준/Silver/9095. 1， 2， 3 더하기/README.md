# [Silver III] 1, 2, 3 더하기 - 9095 

[문제 링크](https://www.acmicpc.net/problem/9095) 

### 성능 요약

메모리: 14124 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 1월 18일 19:46:02

### 문제 설명

<p>정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.</p>

<ul>
	<li>1+1+1+1</li>
	<li>1+1+2</li>
	<li>1+2+1</li>
	<li>2+1+1</li>
	<li>2+2</li>
	<li>1+3</li>
	<li>3+1</li>
</ul>

<p>정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.</p>

### 출력 

 <p>각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.</p>

---

dp

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        int[] dp = new int[11];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i=4; i<11; i++) dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        
        
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            sb.append(dp[k]);
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
}


```
규칙 찾는게 중요

![image](https://github.com/user-attachments/assets/0f2fd79b-d9e7-47e5-a88b-7c4cd9cd2201)

---

![image](https://github.com/user-attachments/assets/74be57de-271a-46b9-8a84-dc1fb8eec546)

