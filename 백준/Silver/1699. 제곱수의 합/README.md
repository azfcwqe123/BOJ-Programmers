# [Silver II] 제곱수의 합 - 1699 

[문제 링크](https://www.acmicpc.net/problem/1699) 

### 성능 요약

메모리: 14736 KB, 시간: 152 ms

### 분류

다이나믹 프로그래밍, 수학

### 제출 일자

2025년 3월 13일 13:12:08

### 문제 설명

<p>어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다. 예를 들어 11=3<sup>2</sup>+1<sup>2</sup>+1<sup>2</sup>(3개 항)이다. 이런 표현방법은 여러 가지가 될 수 있는데, 11의 경우 11=2<sup>2</sup>+2<sup>2</sup>+1<sup>2</sup>+1<sup>2</sup>+1<sup>2</sup>(5개 항)도 가능하다. 이 경우, 수학자 숌크라테스는 “11은 3개 항의 제곱수 합으로 표현할 수 있다.”라고 말한다. 또한 11은 그보다 적은 항의 제곱수 합으로 표현할 수 없으므로, 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3이다.</p>

<p>주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)</p>

### 출력 

 <p>주어진 자연수를 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.</p>

---

dp

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            dp[i] = i; // 제곱수들의 개수는, 해당 숫자의 크기를 초과할 수 없는 성질을 이용
            for(int j=1; j*j<=i; j++) {
                // 제곱수를 이용하여 최소 개수를 찾아낸다.
                if(dp[i] > dp[i - j * j] + 1) dp[i] = dp[i - j * j] + 1;
            }
        }
        
        System.out.print(dp[n]);
    }
    
}


```

---

![7BAqS1502hON6BdaRlmyt5_250313_132519](https://github.com/user-attachments/assets/4fecca8e-e76f-4717-827b-1bb841296956)

![image](https://github.com/user-attachments/assets/358358ca-3d7a-4a78-9d72-4f297e03ebec)

