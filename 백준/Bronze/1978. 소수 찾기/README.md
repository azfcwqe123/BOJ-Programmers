# [Bronze II] 소수 찾기 - 1978 

[문제 링크](https://www.acmicpc.net/problem/1978) 

### 성능 요약

메모리: 14044 KB, 시간: 104 ms

### 분류

소수 판정, 정수론, 수학

### 제출 일자

2024년 10월 21일 15:06:58

### 문제 설명

<p>주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.</p>

### 출력 

 <p>주어진 수들 중 소수의 개수를 출력한다.</p>

---

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int ans = 0;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    while(n-- > 0) {
	        int k = Integer.parseInt(st.nextToken());
	        
	        int cnt = 0;
	        
	        for(int i=2; i<=k; i++) { // 1은 모든 수가 1을 약수로 가지고 있으니 처리하지 않는다.
	            
	            if(k % i == 0) cnt++;
	        }
	        
	        if(cnt == 1) ans++;
	        
	    }
	    
	    System.out.print(ans);
	    
	}
	    
}
	



```
