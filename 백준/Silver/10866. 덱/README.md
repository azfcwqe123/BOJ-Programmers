# [Silver IV] 덱 - 10866 

[문제 링크](https://www.acmicpc.net/problem/10866) 

### 성능 요약

메모리: 20032 KB, 시간: 212 ms

### 분류

자료 구조, 덱, 구현

### 제출 일자

2025년 2월 10일 14:06:23

### 문제 설명

<p>정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.</p>

<p>명령은 총 여덟 가지이다.</p>

<ul>
	<li>push_front X: 정수 X를 덱의 앞에 넣는다.</li>
	<li>push_back X: 정수 X를 덱의 뒤에 넣는다.</li>
	<li>pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
	<li>pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
	<li>size: 덱에 들어있는 정수의 개수를 출력한다.</li>
	<li>empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.</li>
	<li>front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
	<li>back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.</li>
</ul>

### 입력 

 <p>첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.</p>

### 출력 

 <p>출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.</p>

---

덱 자료구조 구현

```java
**import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        Deque deque = new Deque();
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            String ch = st.nextToken();
            
            if(ch.equals("push_front")) {
                deque.push_front(Integer.parseInt(st.nextToken()));
            }
            
            else if(ch.equals("push_back")) {
                deque.push_back(Integer.parseInt(st.nextToken()));
            }
            
            else if(ch.equals("pop_front")) sb.append(deque.pop_front() + "\n");
            else if(ch.equals("pop_back")) sb.append(deque.pop_back() + "\n");
            else if(ch.equals("size")) sb.append(deque.size() + "\n");
            else if(ch.equals("empty")) sb.append(deque.empty() + "\n");
            else if(ch.equals("front")) sb.append(deque.front() + "\n");
            else if(ch.equals("back")) sb.append(deque.back() + "\n");
        }
        
        System.out.print(sb);
        
    }
    
}

class Deque {
    
    int[] arr = new int[20001];
    int front = 10000, back = 10001, size = 0; // 1~10000 -> front, 10001 ~ 20000 -> back
    
    void push_front(int x) {
        arr[front--] = x;
        size++;
    }
    
    void push_back(int x) {
        arr[back++] = x;
        size++;
    }
    
    int pop_front() {
        if(size == 0) return -1;
        size--;
        return arr[++front];
    }
    
    int pop_back() {
        if(size == 0) return -1;
        size--;
        return arr[--back];
    }
    
    int size() {
        return size;
    }
    
    int empty() {
        return size == 0 ? 1 : 0;
    }
    
    int front() {
        return size == 0 ? -1 : arr[front + 1];
    }
    
    int back() {
        return size == 0 ? -1 : arr[back - 1];
    }
    
}

```

---

![image](https://github.com/user-attachments/assets/71eb7586-2b54-46df-96de-0408f0661c58)
