# [Silver III] 단어 뒤집기 2 - 17413 

[문제 링크](https://www.acmicpc.net/problem/17413) 

### 성능 요약

메모리: 23512 KB, 시간: 220 ms

### 분류

자료 구조, 구현, 스택, 문자열

### 제출 일자

2025년 3월 27일 15:41:14

### 문제 설명

<p>문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.</p>

<p>먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.</p>

<ol>
	<li>알파벳 소문자('<code>a</code>'-'<code>z</code>'), 숫자('<code>0</code>'-'<code>9</code>'), 공백('<code> </code>'), 특수 문자('<code><</code>', '<code>></code>')로만 이루어져 있다.</li>
	<li>문자열의 시작과 끝은 공백이 아니다.</li>
	<li>'<code><</code>'와 '<code>></code>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<code><</code>'이 먼저 등장한다. 또, 두 문자의 개수는 같다.</li>
</ol>

<p>태그는 '<code><</code>'로 시작해서 '<code>></code>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<code><</code>'와 '<code>></code>' 사이에는 알파벳 소문자와 공백만 있다. 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.</p>

### 입력 

 <p>첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.</p>

### 출력 

 <p>첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.</p>

---

구현, 스택

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        Stack<Character> stack = new Stack<>();
        
        String str = br.readLine();
        
        boolean open = false;
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == ' ' || ch == '<') { // 공백이나 '<'가 나오면 단어를 뒤집어준다.
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(ch);
                if(ch == '<') open = true; 
                continue;
            }
            
            if(open) sb.append(ch); // 괄호가 열려있는 상태는 뒤집지 않는다.
            else stack.push(ch); // 괄호가 열려있지 않는 상태는 뒤집을 준비를 한다. 
            
            if(ch == '>') open = false; // 괄호를 닫는다.
        }
        
        while(!stack.isEmpty()) sb.append(stack.pop());
        
        System.out.print(sb);
        
    }
    
}


```

스택 자료구조를 사용했지만 구현에 좀 더 초점을 둬야하는 문제

![image](https://github.com/user-attachments/assets/19b3211e-1494-4f78-83b5-6331824742f1)
