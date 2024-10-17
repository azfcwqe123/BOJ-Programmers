# [Bronze I] 진법 변환 2 - 11005 

[문제 링크](https://www.acmicpc.net/problem/11005) 

### 성능 요약

메모리: 14348 KB, 시간: 104 ms

### 분류

구현, 수학

### 제출 일자

2024년 10월 17일 14:27:10

### 문제 설명

<p>10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.</p>

<p>10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.</p>

<p>A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35</p>

### 입력 

 <p>첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36) N은 10억보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 10진법 수 N을 B진법으로 출력한다.</p>

---

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(N > 0) { 몫이 살아있을때까지 실행
	       
	       if(N % B < 10) { // 나머지가 10보다 작으면 숫자 그대로 출력
	           sb.append((char) (N % B + '0'));
	       } else { // 나머지가 10 이상이면 문자로 변환해야됨. 10진법을 넘어가는 진법은 A:10, B:11 등으로 나타내야함.
	           sb.append((char) ((N % B) - 10 + 'A'));
	       }
	       
	       N /= B; // 다음 몫으로 실행
	    } 
	    
	    System.out.println(sb.reverse());
	}
	    
}
	



```

![11005](https://github.com/user-attachments/assets/71da1ed0-cdff-411c-b071-8df022bfacd8)
