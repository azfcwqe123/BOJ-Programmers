# [Silver IV] 균형잡힌 세상 - 4949 

[문제 링크](https://www.acmicpc.net/problem/4949) 

### 성능 요약

메모리: 20000 KB, 시간: 236 ms

### 분류

자료 구조, 스택, 문자열

### 제출 일자

2024년 12월 28일 14:16:53

### 문제 설명

<p>세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.</p>

<p>정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.</p>

<p>문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.</p>

<ul>
	<li>모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.</li>
	<li>모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.</li>
	<li>모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.</li>
	<li>모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.</li>
	<li>짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.</li>
</ul>

<p>정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.</p>

### 입력 

 <p>각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며, 온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.</p>

<div>입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.</div>

### 출력 

 <p>각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.</p>

---

해시맵 + 스택 이용

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static HashMap<Character, Character> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        
        map.put(')', '(');
        map.put(']', '[');
            
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) return;
            
            if(check(str)) System.out.println("yes");
            else System.out.println("no");
        }
        
    }
    
    public static boolean check(String str) {
        
        Stack<Character> stack = new Stack<>();
        
        for(char x : str.toCharArray()) {
            
            if(x == '(' || x == '[') stack.push(x);
            
            else if(x == ')' || x == ']') {
                    
                if(stack.isEmpty()) return false; // 닫는 괄호를 넣으려고 하는데, 스택이 비어있다면 false
                
                else if(stack.peek().equals(map.get(x))) stack.pop(); // 닫는 괄호와의 쌍이 맞으면 그 괄호는 스택에서 빼버린다.
                
                else return false; // (] 이런 케이스는 쌍이 맞지 않으므로, false
                    
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
        
    }
            
}
    



```

---
틀린 풀이

첫번째 풀이 틀린 이유 : check 메서드 마지막에 스택이 비어있는지 여부에 따라 true, false을 해야하는데 이 과정을 생략해버렸다.

추가로 boolean flag라는 변수를 만들 필요 조차도 없었다.

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static HashMap<Character, Character> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        
        map.put(')', '(');
        map.put(']', '[');
            
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) return;
            
            if(check(str)) System.out.println("yes");
            else System.out.println("no");
        }
        
    }
    
    public static boolean check(String str) {
        
        Stack<Character> stack = new Stack<>();
        
        boolean flag = true;
        
        for(char x : str.toCharArray()) {
            
            if(x == '(' || x == '[') stack.push(x);
            
            else if(x == ')' || x == ']') {
                    
                if(stack.isEmpty()) return false;
                
                else if(stack.peek().equals(map.get(x))) stack.pop();
                
                else return false;
                    
            }
        }
        
        return flag;
    }
            
}
    



```

---

![image](https://github.com/user-attachments/assets/f0876b9d-f0ae-413d-98be-97e8a93fb0fc)
