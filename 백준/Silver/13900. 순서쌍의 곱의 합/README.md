# [Silver IV] 순서쌍의 곱의 합 - 13900 

[문제 링크](https://www.acmicpc.net/problem/13900) 

### 성능 요약

메모리: 25900 KB, 시간: 268 ms

### 분류

수학, 누적 합

### 제출 일자

2024년 12월 4일 20:03:29

### 문제 설명

<p>N개의 정수 중 서로 다른 위치의 두 수를 뽑는 모든 경우의 두 수의 곱의 합을 구하라.</p>

<p>예를 들어 N = 3이고 주어진 정수가 2, 3, 4일 때, 두 수를 뽑는 모든 경우는 (2, 3), (2, 4), (3, 4)이며 이때 각각의 곱은 6, 8, 12이다. 따라서 총합은 26이다.</p>

### 입력 

 <p>첫 번째 줄에는 입력 받을 정수의 개수 N(<strong>2 ≤ N ≤ 100,000</strong>)</p>

<p>두 번째 줄에는 N 개의 정수가 주어진다. 이때 입력 받는 정수들의 범위는 <strong>0이상 10,000 이하이다.</strong></p>

### 출력 

 <p>모든 경우의 곱의 합을 출력한다.</p>

---

누적합 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    long[] arr = new long[n+1];
	    long[] sum = new long[n+1];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=1; i<=n; i++) arr[i] = Long.parseLong(st.nextToken());
	    
	    for(int i=1; i<=n; i++) sum[i] = sum[i-1] + arr[i];
	    
	    
	    long ans = 0;
	    for(int i=1; i<n; i++) ans += (sum[n] - sum[i]) * arr[i];    
	    
	    
	    System.out.print(ans);
	    
	    // 1 2 3 4의 순서쌍을 찾아보면 
	    // (1,2) (1,3) (1, 4)
	    // (2,3) (2,4)
	    // (3,4)
	    
	    // 순서쌍의 곱으로 정리해보면
	    // 1 * (2 + 3 + 4)
	    // 2 * (3 + 4)
	    // 3 * (4)
	    
	    // 즉,
	    // arr[1] * (sum[4] - sum[1])
	    // arr[2] * (sum[4] - sum[2])
	    // arr[3] * (sum[4] - sum[3])
	    
	    // 이러한 규칙이 나오게 된다.
    }

}
```

규칙을 찾아내서 누적합 알고리즘으로 풀어낸다.
