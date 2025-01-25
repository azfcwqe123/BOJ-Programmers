# [Gold IV] 카드 정렬하기 - 1715 

[문제 링크](https://www.acmicpc.net/problem/1715) 

### 성능 요약

메모리: 26132 KB, 시간: 316 ms

### 분류

자료 구조, 그리디 알고리즘, 우선순위 큐

### 제출 일자

2025년 1월 25일 12:39:54

### 문제 설명

<p>정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다. 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.</p>

<p>매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다. 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다. 그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.</p>

<p>N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.</p>

### 출력 

 <p>첫째 줄에 최소 비교 횟수를 출력한다.</p>

---

그리디 알고리즘 + 우선순위큐, 최소힙

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            pQ.offer(k);
        }
        
        int sum = 0, tmp = 0;
        
        while(!pQ.isEmpty()) {
            
            if(pQ.size() == 1) break;
            
            if(pQ.size() > 1) {
                tmp = pQ.poll() + pQ.poll();
                sum += tmp;
                pQ.offer(tmp);
            }
        }
        
        System.out.print(sum);
    }
    
}


```

주의해야할 것

1. 두 묶음의 숫자가 있을때만 비교횟수가 늘어남, A와 B가 있으면 (A+B)번만큼 늘지만, 처음부터 A만 있다면 비교대상이 없기에 비교횟수가 0이 됨.
   
---

리팩토링

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            pQ.offer(k);
        }
        
        int sum = 0, tmp = 0;
        
        while(pQ.size() > 1) {
            tmp = pQ.poll() + pQ.poll();
            sum += tmp;
            pQ.offer(tmp);
        }
        
        System.out.print(sum);
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/fd81dbaf-d8a8-4077-af8f-0737d693dddc)
