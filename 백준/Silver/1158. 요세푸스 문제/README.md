# [Silver IV] 요세푸스 문제 - 1158 

[문제 링크](https://www.acmicpc.net/problem/1158) 

### 성능 요약

메모리: 295992 KB, 시간: 596 ms

### 분류

자료 구조, 구현, 큐

### 제출 일자

2024년 12월 23일 18:07:00

### 문제 설명

<p>요세푸스 문제는 다음과 같다.</p>

<p>1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.</p>

<p>N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)</p>

### 출력 

 <p>예제와 같이 요세푸스 순열을 출력한다.</p>

---

큐

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        Queue<Integer> Q = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; i++) Q.offer(i);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(Q.size() != 1) {
            for(int i=1; i<K; i++) Q.offer(Q.poll());
            sb.append(Q.poll() + ", ");
        }
        
        sb.append(Q.poll() + ">");
        System.out.print(sb);
        
    }
    
}


```

---

실수한 풀이, K가 3으로 고정돼있다고 착각을 함

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        Queue<Integer> Q = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; i++) Q.offer(i);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!Q.isEmpty()) {
            
            Q.offer(Q.poll());
            Q.offer(Q.poll());
            list.add(Q.poll());
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<N-1; i++) sb.append(list.get(i) + ", ");
        sb.append(list.get(N-1) + ">");
        
        System.out.print(sb);
        
    }
    
}


```

---
