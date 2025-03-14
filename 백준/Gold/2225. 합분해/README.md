# [Gold V] 합분해 - 2225 

[문제 링크](https://www.acmicpc.net/problem/2225) 

### 성능 요약

메모리: 14332 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍, 수학

### 제출 일자

2025년 3월 14일 18:33:19

### 문제 설명

<p>0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.</p>

<p>덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.</p>

### 입력 

 <p>첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.</p>

### 출력 

 <p>첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.</p>

---

DP

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[k+1][n+1];
        
        Arrays.fill(dp[1], 1); // k가 1일 경우
        
        for(int i=2; i<=k; i++) {
            dp[i][0] = 1; // n이 0일때, 1개만큼 생성 가능, 0, 0+0, 0+0+0...
            for(int j=1; j<=n; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
            }
        }
        
        System.out.print(dp[k][n]);
    }
    
}


```

![bdy9jPIfTIkGoZbd88BcD2_250314_184002](https://github.com/user-attachments/assets/67f984eb-216d-420d-b383-9c74c7dfb48d)

1시간동안 고민하고 풀었는데 답이 안나와서 블로그를 참고했다.
-> https://hu-coding.tistory.com/28

2차원 배열을 사용하지 않고, 1차원 배열 관점에서 생각하니 정답이 도저히 나오지 않았다. 조합까지 써야하나 생각을 해봤지만, 조합을 쓸 만큼 장황한 문제는 아니었던것 같다.

규칙을 찾을때는 2차원 배열로 활용 잘 해보자. 중요하다

---

![image](https://github.com/user-attachments/assets/59b58901-ba84-4137-a4d2-3facc64efcfe)
