# [Bronze V] A+B - 7 - 11021 

[문제 링크](https://www.acmicpc.net/problem/11021) 

### 성능 요약

메모리: 14600 KB, 시간: 116 ms

### 분류

구현, 사칙연산, 수학

### 제출 일자

2024년 10월 8일 22:34:30

### 문제 설명

<p>두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다.</p>

<p>각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)</p>

### 출력 

 <p>각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.</p>


---

첫번째 풀이

```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException { 
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        sb.append("Case #" + (i+1) + ": " + (a+b)).append("\n");
	    }
	    
	    System.out.print(sb);
	    
	}
}   


```

두번째 풀이 (String.format() 이)

```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        String str = String.format("Case #%d: %d",i+1, a+b);
	        sb.append(str).append('\n');
	    }
	    
	    System.out.print(sb);
	    
	}
}   


```
