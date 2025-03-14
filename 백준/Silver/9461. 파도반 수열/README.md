# [Silver III] 파도반 수열 - 9461 

[문제 링크](https://www.acmicpc.net/problem/9461) 

### 성능 요약

메모리: 14228 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍, 수학

### 제출 일자

2025년 3월 14일 17:03:55

### 문제 설명

<p><img alt="" src="https://www.acmicpc.net/upload/images/pandovan.png" style="float:right; height:182px; width:289px">오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.</p>

<p>파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.</p>

<p>N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)</p>

### 출력 

 <p>각 테스트 케이스마다 P(N)을 출력한다.</p>

---

DP

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            long[] dp = new long[n+2]; // n이 1이 들어와도 dp[2]까지는 적을 수 있게 배열의 크기를 n+2로 설정했다. 
            
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            
            for(int i=3; i<=n; i++) {
                dp[i] = dp[i-3] + dp[i-2]; // 배열의 크기가 n+2면, dp[i-3]까지 입력할 수 있기에 관리하기 편리하다.
            }
            
            System.out.println(dp[n]);
        }
        
    }
    
}


```

![PBN3jMFaYXrm0TiWx9Okrl_250314_171323](https://github.com/user-attachments/assets/7bb6b519-bbe7-493e-8e0e-fc4464cf82ab)

---

![image](https://github.com/user-attachments/assets/b737e407-bf1a-473b-9f6d-fe466c569a5c)

틀린이유: 배열을 int형으로 설정해서 틀림.

테스트 케이스에 100을 입력해봤더니 오버플로우 현상을 확인해서 long 배열 타입으로 바꿔주니 해결됐다.

배열의 요소가 피보나치 수열 느낌으로 증가한다면 오버플로우가 발생할지 의심해보는게 좋다.
