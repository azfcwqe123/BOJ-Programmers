# [Bronze II] 단어의 개수 - 1152 

[문제 링크](https://www.acmicpc.net/problem/1152) 

### 성능 요약

메모리: 20136 KB, 시간: 244 ms

### 분류

구현, 문자열

### 제출 일자

2024년 10월 12일 18:22:36

### 문제 설명

<p>영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.</p>

### 입력 

 <p>첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.</p>

### 출력 

 <p>첫째 줄에 단어의 개수를 출력한다.</p>

---

첫번째 풀이, trim() 이용

```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine().trim();
	    
	    if(str.length() == 0) System.out.print(0); // 공백만 입력하면 결과가 1이 나오는 현상이 발생하기 때문에, 0을 따로 처리해줘야함
	    else System.out.print(str.split(" ").length);
	    
	    
	}
}   

```

---

두번째 풀이, st.countTokens() 이용
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    System.out.print(st.countTokens());
	    
	}
	
}   
```

실행 시간: 1번 풀이(272ms) > 2번 풀이(242ms) 
