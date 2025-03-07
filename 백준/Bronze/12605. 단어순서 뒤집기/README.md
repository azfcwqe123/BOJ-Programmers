# [Bronze II] 단어순서 뒤집기 - 12605 

[문제 링크](https://www.acmicpc.net/problem/12605) 

### 성능 요약

메모리: 14056 KB, 시간: 100 ms

### 분류

자료 구조, 파싱, 스택, 문자열

### 제출 일자

2024년 12월 4일 20:38:30

### 문제 설명

<p dir="ltr">스페이스로 띄어쓰기 된 단어들의 리스트가 주어질때, 단어들을 반대 순서로 뒤집어라. 각 라인은 w개의 영단어로 이루어져 있으며, 총 L개의 알파벳을 가진다. 각 행은 알파벳과 스페이스로만 이루어져 있다. 단어 사이에는 하나의 스페이스만 들어간다.</p>

### 입력 

 <p dir="ltr">첫 행은 N이며, 전체 케이스의 개수이다.</p>

<p>N개의 케이스들이 이어지는데, 각 케이스는 스페이스로 띄어진 단어들이다. 스페이스는 라인의 처음과 끝에는 나타나지 않는다. N과 L은 다음 범위를 가진다.</p>

<ul>
	<li><strong>N</strong> = 5</li>
	<li>1 ≤ <strong>L</strong> ≤ 25</li>
</ul>

### 출력 

 <p dir="ltr">각 케이스에 대해서, 케이스 번호가 x일때  "Case #x: " 를 출력한 후 그 후에 이어서 단어들을 반대 순서로 출력한다.</p>

---

스택 기본 문제
```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<String> stack = new Stack<>();
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i=1; i<=n; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        while(st.hasMoreTokens()) stack.push(st.nextToken());
	        
	        sb.append("Case #").append(i).append(": ");
	        while(!stack.isEmpty()) {
	           sb.append(stack.pop() + " ");
	        }
	        sb.append('\n');
	    }
	    
	    System.out.print(sb);
    }

}
```
