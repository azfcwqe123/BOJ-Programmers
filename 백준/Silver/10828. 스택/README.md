# [Silver IV] 스택 - 10828 

[문제 링크](https://www.acmicpc.net/problem/10828) 

### 성능 요약

메모리: 19208 KB, 시간: 160 ms

### 분류

자료 구조, 구현, 스택

### 제출 일자

2024년 12월 27일 19:13:50

### 문제 설명

<p>정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.</p>

<p>명령은 총 다섯 가지이다.</p>

<ul>
	<li>push X: 정수 X를 스택에 넣는 연산이다.</li>
	<li>pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
	<li>size: 스택에 들어있는 정수의 개수를 출력한다.</li>
	<li>empty: 스택이 비어있으면 1, 아니면 0을 출력한다.</li>
	<li>top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
</ul>

### 입력 

 <p>첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.</p>

### 출력 

 <p>출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.</p>

---

스택 자료구조 구현

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] stack;
    public static int size = 0;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        stack = new int[n];
        
        while(n-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()) {
                
                case "push" : 
                    push(Integer.parseInt(st.nextToken()));
                    break;
                
                case "pop" :
                    sb.append(pop()).append('\n');
                    break;
                
                case "size" :
                    sb.append(size()).append('\n');
                    break;
                
                case "empty" :
                    sb.append(empty()).append('\n');
                    break;
                    
                case "top" :
                    sb.append(top()).append('\n');
                    break;
            }
            
        }
        
        System.out.print(sb);
        
    }
    
    //---
    
    public static void push(int item) {
        stack[size] = item;
        size++;
    }
    
    public static int pop() {
        
        if(size == 0) return -1;
        else {
            int tmp = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return tmp;
        }
    }
    
    public static int size() {
        return size;
    }
    
    public static int empty() {
        return size == 0 ? 1 : 0;
    }
    
    public static int top() {
        if(size == 0) return -1;
        else return stack[size - 1];
    }
    
}


```

---

참고 블로그 : https://st-lab.tistory.com/175

![image](https://github.com/user-attachments/assets/4f478c74-dba6-4f72-a617-939a8edd1f16)
