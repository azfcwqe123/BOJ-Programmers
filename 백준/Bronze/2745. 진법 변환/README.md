# [Bronze II] 진법 변환 - 2745 

[문제 링크](https://www.acmicpc.net/problem/2745) 

### 성능 요약

메모리: 14360 KB, 시간: 104 ms

### 분류

구현, 문자열, 수학

### 제출 일자

2024년 10월 17일 12:47:57

### 문제 설명

<p>B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.</p>

<p>10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.</p>

<p>A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35</p>

### 입력 

 <p>첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)</p>

<p>B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄에 B진법 수 N을 10진법으로 출력한다.</p>

---

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    String N = st.nextToken();
	    int B = Integer.parseInt(st.nextToken());
	    int exponent = 0;
	    int res = 0;
	    
	    for(int i=N.length()-1; i>=0; i--) {
	        char ch = N.charAt(i);
	        int k = 0;
	        
	        if(ch >= '0' && ch <= '9') {
	            k = ch - '0';
	        } else {
	            k = ch - 55; // k = ch - '55'는 불가능. 단일 문자 리터럴만 가능하다. 여러 문자로 된 리터럴은 불가능(ex. '12')
	        }
	        
	        res += k * Math.pow(B,exponent++);
	    }
	    
	    System.out.print(res);
	    
	    
	}
	    
}
	


```

![2745](https://github.com/user-attachments/assets/a2d8b0f7-9f32-4f5c-ab4c-52fa80897c2e)

