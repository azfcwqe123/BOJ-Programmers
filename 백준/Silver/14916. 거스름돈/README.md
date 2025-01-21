# [Silver V] 거스름돈 - 14916 

[문제 링크](https://www.acmicpc.net/problem/14916) 

### 성능 요약

메모리: 14292 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍, 그리디 알고리즘, 수학

### 제출 일자

2025년 1월 21일 14:36:00

### 문제 설명

<p>춘향이는 편의점 카운터에서 일한다.</p>

<p>손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.</p>

<p>예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.</p>

### 입력 

 <p>첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.</p>

### 출력 

 <p>거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.</p>

---

그리디 알고리즘 풀이 1

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        if(n == 1 || n == 3) {
            System.out.print(-1);
            System.exit(0);
        }
        
        int cnt = 0;
        
        while(true) {
            
            if(n % 5 == 0) {
                cnt += n / 5;
                break;
            }
            
            n -= 2;
            cnt++;
        }
        
        System.out.print(cnt);
    }
    
}


```

정수론을 생각하면서 푼 문제인데, 음수를 제외하고 2와 5로 조합할 수 있는 숫자는 1과 3 제외하면 모두 만들 수 있었다.

---

그리디 알고리즘 풀이 2

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        
        while(true) {
            
            if(n % 5 == 0) {
                cnt += n / 5;
                System.out.print(cnt);
                break;
            }
            
            else {
                n -= 2;
                cnt++;
            }
            
            if(n < 0) { // 핵심
                System.out.print(-1);
                break;
            }
            
        }
        
        
    }
    
}
```

참고: https://jaewoo2233.tistory.com/55

---

dp 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        final int INF = Integer.MAX_VALUE;
        
        int[] dp = new int[100001];
        
        dp[1] = INF;
        dp[2] = 1;
        dp[3] = INF;
        dp[4] = 2;
        dp[5] = 1;
        
        for(int i=6; i<=n; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
        }
        
        System.out.print(dp[n] == INF ? -1 : dp[n]);
    }
    
}


```

참고: https://luz315.tistory.com/164

---

![image](https://github.com/user-attachments/assets/9da96b42-2447-4e25-90bd-3d5b7d5c9fa7)
