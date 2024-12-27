# [Silver IV] 큐 - 10845 

[문제 링크](https://www.acmicpc.net/problem/10845) 

### 성능 요약

메모리: 19360 KB, 시간: 160 ms

### 분류

자료 구조, 큐

### 제출 일자

2024년 12월 27일 19:35:14

### 문제 설명

<p>정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.</p>

<p>명령은 총 여섯 가지이다.</p>

<ul>
	<li>push X: 정수 X를 큐에 넣는 연산이다.</li>
	<li>pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
	<li>size: 큐에 들어있는 정수의 개수를 출력한다.</li>
	<li>empty: 큐가 비어있으면 1, 아니면 0을 출력한다.</li>
	<li>front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
	<li>back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
</ul>

### 입력 

 <p>첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.</p>

### 출력 

 <p>출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.</p>

---

큐 자료구조 구현

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] Q = new int[10001]; // 문제 조건처럼 10000개의 수가 들어갔다 나올 수 있으니, 미리 설정해놓는다.
    public static int first = 0, last = 0;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        Q = new int[n];
        
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
                
                case "front" :
                    sb.append(front()).append('\n');
                    break;
                
                case "back" :
                    sb.append(back()).append('\n');
                    break;
            }
            
        }
        
        System.out.print(sb);
        
    }
    
    //---
    
    public static void push(int item) {
        Q[last++] = item;
    }
    
    public static int pop() {
        if(last - first == 0) return -1;
        else {
            int tmp = Q[first++];
            return tmp;
        }
    }
    
    public static int size() {
        return last - first;
    }
    
    public static int empty() {
        if(last - first == 0) return 1;
        else return 0;
    }
    
    public static int front() {
        if(last - first == 0) return -1;
        else {
            int tmp = Q[first];
            return tmp;
        }
    }
    
    public static int back() {
        if(last - first == 0) return -1;
        else {
            int tmp = Q[last - 1];
            return tmp;
        }
    }
    
}


```

---

참고 블로그 : https://comain.tistory.com/272

![image](https://github.com/user-attachments/assets/9507a504-a435-4a26-b75b-659cc8c8ea52)
