# [Bronze II] 상수 - 2908 

[문제 링크](https://www.acmicpc.net/problem/2908) 

### 성능 요약

메모리: 14204 KB, 시간: 100 ms

### 분류

구현, 수학

### 제출 일자

2024년 10월 12일 18:27:50

### 문제 설명

<p>상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.</p>

<p>상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.</p>

<p>두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.</p>

### 출력 

 <p>첫째 줄에 상수의 대답을 출력한다.</p>

---

첫번째 풀이, StringBuilder 메서드 이용
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
	    int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
	    
	    System.out.print(a>b ? a : b);
	    
	}
	
}   



```

---

두번째 풀이, 직접 숫자를 바꾸기
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    String str1 = st.nextToken();
	    String str2 = st.nextToken();
	    
	    char[] a = new char[3];
	    char[] b = new char[3];
	    
	    // 핵심 코드 
	    int k = 0;
	    for(int i=2; i>=0; i--) {
	        a[i] = str1.charAt(k);
	        b[i] = str2.charAt(k);
	        k++;
	    }
	    
	    // char 배열을 String형으로 전환
	    String c = new String(a);
	    String d = new String(b);
	    
	    System.out.print(Integer.parseInt(c) > Integer.parseInt(d) ? Integer.parseInt(c) : Integer.parseInt(d)); 
	    
	}
	
}   



```
