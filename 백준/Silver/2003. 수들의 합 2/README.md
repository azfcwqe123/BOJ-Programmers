# [Silver IV] 수들의 합 2 - 2003 

[문제 링크](https://www.acmicpc.net/problem/2003) 

### 성능 요약

메모리: 15048 KB, 시간: 124 ms

### 분류

브루트포스 알고리즘, 누적 합, 두 포인터

### 제출 일자

2024년 12월 2일 17:44:38

### 문제 설명

<p>N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.</p>

### 출력 

 <p>첫째 줄에 경우의 수를 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    int lt=0, rt = 0;
	    
	    int ans = 0, sum = 0;
	    
	    while(rt < n) {
	        
	        sum += arr[rt++];
	        
	        if(sum == m) ans++; 
	           
	        while(sum >= m) {
	            sum -= arr[lt++];
	            if(sum == m) ans++;
	        }
	    }
	    
	    
	    System.out.print(ans);

	    
    }
    
}
```
