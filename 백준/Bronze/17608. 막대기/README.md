# [Bronze II] 막대기 - 17608 

[문제 링크](https://www.acmicpc.net/problem/17608) 

### 성능 요약

메모리: 24768 KB, 시간: 256 ms

### 분류

자료 구조, 구현, 스택

### 제출 일자

2024년 12월 4일 20:50:53

### 문제 설명

<p>아래 그림처럼 높이만 다르고 (같은 높이의 막대기가 있을 수 있음) 모양이 같은 막대기를 일렬로 세운 후, 왼쪽부터 차례로 번호를 붙인다. 각 막대기의 높이는 그림에서 보인 것처럼 순서대로 6, 9, 7, 6, 4, 6 이다. 일렬로 세워진 막대기를 오른쪽에서 보면 보이는 막대기가 있고 보이지 않는 막대기가 있다. 즉, 지금 보이는 막대기보다 뒤에 있고 높이가 높은 것이 보이게 된다. 예를 들어, 그림과 같은 경우엔 3개(6번, 3번, 2번)의 막대기가 보인다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/a2ebef22-157f-4059-9bdd-6a0662b81698/-/crop/675x304/47,12/-/preview/" style="width: 333px; height: 150px;"></p>

<p>N개의 막대기에 대한 높이 정보가 주어질 때, 오른쪽에서 보아서 몇 개가 보이는지를 알아내는 프로그램을 작성하려고 한다.</p>

### 입력 

 <p>첫 번째 줄에는 막대기의 개수를 나타내는 정수 N (2 ≤ N ≤ 100,000)이 주어지고 이어지는 N줄 각각에는 막대기의 높이를 나타내는 정수 h(1 ≤ h ≤ 100,000)가 주어진다.</p>

### 출력 

 <p>오른쪽에서 N개의 막대기를 보았을 때, 보이는 막대기의 개수를 출력한다.</p>

---

스택

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    while(n-- > 0) {
	        
	        int tmp = Integer.parseInt(br.readLine());
	        
	        // tmp(막대기)보다 작거나 같은 막대기들을 모조리 없앤다.
	        // while문에서 stack.peek()이 먼저 나오면, EmptyStackException이 뜬다. 꺼낼 요소가 없기때문.
	        while(!stack.isEmpty() && stack.peek() <= tmp) stack.pop();    
	        
	        stack.push(tmp);
	    }
	    
	    System.out.print(stack.size());
	    
    }

}
```
