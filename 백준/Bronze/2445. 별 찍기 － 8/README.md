# [Bronze III] 별 찍기 - 8 - 2445 

[문제 링크](https://www.acmicpc.net/problem/2445) 

### 성능 요약

메모리: 14456 KB, 시간: 116 ms

### 분류

구현

### 제출 일자

2024년 10월 23일 12:55:14

### 문제 설명

<p>예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.</p>

### 출력 

 <p>첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.</p>

---

첫번째 풀이, 2중 for문 사용

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=0; j<i+1; j++) {
	            sb.append("*");
	        }
	        
	        for(int k=0; k<(n-1)*2-2*i; k++) {
	            sb.append(" ");
	        }	        
	        
	        for(int j=0; j<i+1; j++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	    }
	    
	    sb.append("*".repeat(n*2));
	    
	    sb.append("\n");
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=i; j<n-1; j++) {
	            sb.append("*");
	        }
	        
	        for(int k=0; k< 2*(i+1); k++) {
	            sb.append(" ");
	        }
	        
	        for(int j=i; j<n-1; j++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}




```

---

두번째 풀이, repeat() 메서드 사용 

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=1; i<n; i++) {
	        sb.append("*".repeat(i) + " ".repeat(n*2 - 2*i) + "*".repeat(i)).append("\n");
	    }
	    
	    sb.append("*".repeat(n*2)).append("\n");
	    
	    for(int i=1; i<n; i++) {
	        sb.append("*".repeat(n-i) + " ".repeat(2*i) + "*".repeat(n-i)).append("\n");
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}

```

확실히 repeat() 메서드가 더 직관적이고 풀기는 간단하다. 하지만 실행속도가 for문 보다 36ms나 더 빠르다.

추가로 4 / 1 / 4 구조로 나눠서 풀었는데, n=5일때 for문의 조건을 i=0; i<n-1;으로 하는것보다 i=1; i<n;으로 하는게 더 풀기 수월했었다.

