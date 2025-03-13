# [Gold IV] 타일 채우기 - 2133 

[문제 링크](https://www.acmicpc.net/problem/2133) 

### 성능 요약

메모리: 16128 KB, 시간: 128 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 13일 16:04:26

### 문제 설명

<p>3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.</p>

### 출력 

 <p>첫째 줄에 경우의 수를 출력한다.</p>

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
        
        if(n % 2 != 0) {
            System.out.print(0);
            System.exit(0);
        }
        
        int[] dp = new int[n+1];
        
        dp[2] = 3;
        
        for(int i=4; i<=n; i+=2) {
            dp[i] = dp[i-2] * 3;
            for(int j=i-4; j >=0; j-=2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2;
        }
        
        System.out.print(dp[n]);
    
    }
    
}


```

---

![lzpljsngVdvSmDTNPw3pRk_250313_162044_1](https://github.com/user-attachments/assets/8d22ed1f-46ff-423a-b312-505860ad46ef)

![lzpljsngVdvSmDTNPw3pRk_250313_162044_2](https://github.com/user-attachments/assets/c6fbdbed-aeb6-4e6f-839d-97be8ee2ba8e)

---

참고 블로그 : https://eunchaan.tistory.com/51

![image](https://github.com/user-attachments/assets/70e884af-fd85-4436-b3ab-841548f6e27d)

