# [Bronze I] 단어 공부 - 1157 

[문제 링크](https://www.acmicpc.net/problem/1157) 

### 성능 요약

메모리: 21132 KB, 시간: 240 ms

### 분류

구현, 문자열

### 제출 일자

2024년 10월 13일 20:30:30

### 문제 설명

<p>알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.</p>

### 입력 

 <p>첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.</p>

### 출력 

 <p>첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.</p>

---

첫번째 풀이, O(2n + 26 + 26)
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine().toUpperCase(); // 문자열 변환 O(n)
	    
	    int[] arr = new int[26];
	    
	    for(int i=0; i<str.length(); i++) { // O(n)
	        arr[str.charAt(i) - 'A']++;
	    } // 배열에 A~Z까지 문자의 횟수를 저장해놓는다.
	    
	    int max = 0;
	    int index = 0;
	    
	    for(int i=0; i<26; i++) { // O(26) -> O(1)
	        if(arr[i] > max) {
	            max = arr[i];
	            index = i;
	        }
	    } // 최댓값을 추출해내고, 최댓값의 배열의 인덱스를 저장해놓는다.
	    
	    int cnt = 0;
 
	    for(int x : arr) { // O(26) -> O(1)
	        if(x==max) cnt++;

           /*if(cnt >= 2) {
	            System.out.print("?");
	            return;
	        }*/ //이런식으로도 처리 가능

	    } // 최댓값과 같은게 몇번 나왔는지 확인한다. 2번 이상 나오면 "?"를 출력시킨다.


            // 마지막 처리
	    if(cnt >= 2) System.out.print("?");
	    else System.out.print((char) (index + 65));
	    
	    
	}
	
}   



```

---

리팩터링, O(2n + 26)
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine().toUpperCase(); // O(n)
	    
	    int[] arr = new int[26];
	    
	    for(int i=0; i<str.length(); i++) { // O(n)
	        arr[str.charAt(i) - 'A']++;
	    }
	    
	    int max = 0;
	    char ans = '?';
	    
	    for(int i=0; i<26; i++) { // O(26), 핵심 코드
	        if(arr[i] > max) {
	            max = arr[i];
	            ans = (char) (i+65);
	        } else if(arr[i] == max) {
	            ans = '?';
	        }
	    }
	    
	    System.out.print(ans);
	    
	}
	
}   



```
