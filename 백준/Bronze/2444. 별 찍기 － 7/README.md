# [Bronze III] 별 찍기 - 7 - 2444 

[문제 링크](https://www.acmicpc.net/problem/2444) 

### 성능 요약

메모리: 14236 KB, 시간: 104 ms

### 분류

구현

### 제출 일자

2024년 10월 13일 20:02:10

### 문제 설명

<p>예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.</p>

### 출력 

 <p>첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.</p>

---
2중 for문 풀이, 112ms
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=n-i-1; j>=1; j--) {
	            sb.append(" ");
	        }
	        
	        for(int k=0; k<i*2+1; k++) {
	            sb.append("*");
	        }
	        
	        sb.append("\n");
	    }
	    
	    for(int i=0; i<n*2-1; i++) {
	        sb.append("*");
	    }
	    sb.append("\n");
	    
	    for(int i=0; i<n-1; i++) {
	        
	        for(int j=0; j<=i; j++) {
	            sb.append(" ");
	        }
	        
	        for(int k=0; k<2*(n-1)-1 -i*2; k++) { // 주어진 n을 활용 잘 하자. 2개씩 줄어들기에 -i*2
	            sb.append("*");
	        }
	        sb.append("\n");
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	
}   



```

---
repeat() 풀이, 104ms
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    
	    for(int i=0; i<n-1; i++) {
	        sb.append(" ".repeat(n-1-i));
	        sb.append("*".repeat(2*i+1));
	        sb.append("\n");
	    }
	    
	    sb.append("*".repeat(2*n-1)).append("\n");
	    
	    for(int i=0; i<n-1; i++) {
	        sb.append(" ".repeat(i+1));
	        sb.append("*".repeat(2*(n-1)-1-2*i));
	        sb.append("\n");
	    }
	    
	    System.out.print(sb);
	    
	}
	
}   



```
