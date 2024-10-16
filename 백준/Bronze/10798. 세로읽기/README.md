# [Bronze I] 세로읽기 - 10798 

[문제 링크](https://www.acmicpc.net/problem/10798) 

### 성능 요약

메모리: 14316 KB, 시간: 96 ms

### 분류

구현, 문자열

### 제출 일자

2024년 10월 16일 13:28:10

### 문제 설명

<p>아직 글을 모르는 영석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다. </p>

<p>이 장난감에 있는 글자들은 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’이다. 영석이는 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만든다. 다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다. 이런 식으로 다섯 개의 단어를 만든다. 아래 그림 1은 영석이가 칠판에 붙여 만든 단어들의 예이다. </p>

<pre>A A B C D D
a f z z 
0 9 1 2 1
a 8 E W g 6
P 5 h 3 k x</pre>

<p><그림 1></p>

<p>한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다. 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다. </p>

<p>심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다. 세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 다음에 두 번째 글자들을 세로로 읽는다. 이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다. 위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다. 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다. 그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다. </p>

<p>그림 1에서 영석이가 세로로 읽은 순서대로 글자들을 공백 없이 출력하면 다음과 같다:</p>

<p>Aa0aPAf985Bz1EhCz2W3D1gkD6x</p>

<p>칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다. 주어지는 글자는 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’ 중 하나이다. 각 줄의 시작과 마지막에 빈칸은 없다.</p>

### 출력 

 <p>영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다. </p>

---

1. char 배열의 초기값, 최고 길이를 구한 메모리 절약 방법
```java
import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char[][] arr = new char[5][15];
	    
	    int max_length = 0; // 메모리 절약을 위해 max_length 설정
	    
	    for(int i=0; i<5; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	
	        String str = st.nextToken();
	        max_length = Math.max(max_length, str.length());
	        
	        for(int j=0; j<str.length(); j++) {
	            arr[i][j] = str.charAt(j);    
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<max_length; i++) {
	        
	        for(int j=0; j<5; j++) {
	            if(arr[j][i] == '\u0000') continue; // char 배열의 초기값은 '\u0000'
	            sb.append(arr[j][i]);        
	        }
	    }
	    
	    System.out.print(sb);
	        
	}
	    
}
	



```

---

2. String 배열로 풀려고 한 문제, 런타임 에러.
```java
import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] arr = new String[5];
	    
	    int max_length = -1;
	    
	    for(int i=0; i<5; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        String str = st.nextToken();
	        max_length = Math.max(max_length,str.length());
	        
	        arr[i] = str;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<max_length; i++) {
	        
	        for(int j=0; j<5; j++) {
	            if(arr[j].charAt(i) == '\u0000') continue; // 런타임 에러 발생. String 길이의 범위를 벗어난 문자열을 .charAt() 했을때 일어난 문제
	            
	            sb.append(arr[j].charAt(i));
	        }   
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}
	



```

---

```java
import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] arr = new String[5];
	    
	    int max_length = -1;
	    
	    for(int i=0; i<5; i++) {
	        
	        String str = br.readLine();
	        max_length = Math.max(max_length,str.length());
	        
	        arr[i] = str;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0; i<max_length; i++) {
	        
	        for(int j=0; j<5; j++) {
	            
	            if(i < arr[j].length()) { // 현재 문자열의 위치가 String 문자열 길이보다 작을때 추가.
	                sb.append(arr[j].charAt(i));
	            }
	        }   
	        
	    }
	    
	    System.out.print(sb);
	    
	}
	    
}
	



```


