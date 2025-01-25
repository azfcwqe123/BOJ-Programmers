# [Gold IV] 수 묶기 - 1744 

[문제 링크](https://www.acmicpc.net/problem/1744) 

### 성능 요약

메모리: 14216 KB, 시간: 104 ms

### 분류

많은 조건 분기, 그리디 알고리즘, 정렬

### 제출 일자

2025년 1월 25일 13:20:33

### 문제 설명

<p>길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.</p>

<p>예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.</p>

<p>수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.</p>

<p>수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다. 둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다. 수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.</p>

### 출력 

 <p>수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 2<sup>31</sup>보다 작다.</p>

---

그리디 알고리즘 + 우선순위 큐

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mQ = new PriorityQueue<>();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            if(k > 0) pQ.offer(k);
            else mQ.offer(k);
        }
        
        solution(pQ);
        solution(mQ);
        
        int a = 0, b = 0;

        // 마지막 처리
        if(!pQ.isEmpty() && !mQ.isEmpty()) {
            a = pQ.poll();
            b = mQ.poll();
            
            ans += Math.max(a * b, a + b);
        }
        
        else if(!pQ.isEmpty()) ans += pQ.poll();
        else if(!mQ.isEmpty()) ans += mQ.poll();
        
        System.out.print(ans);
        
    }
    
    static void solution(PriorityQueue<Integer> Q) {
        
        int a = 0, b = 0;
        
        while(Q.size() > 1) {
            a = Q.poll();
            b = Q.poll();
            
            ans += Math.max(a * b, a + b);
        }
    }
    
}


```

1. 1 이상인 양수만 담을 수 있는 큐(최대 힙)와, 0이하 음수만 담을 수 있는 큐(최소 힙)를 두 개 만든다. // 양수 큐: 5 4 3 2 1 | 음수 큐: -3 -2 -1 0 같은 느낌으로 

2. 0을 음수 큐에 넣는 이유는, 수열의 합을 최대로 만들기 위해서는 0과 음수를 곱해버리는게 최댓값을 만드는데 기여하기 때문에, 양수 큐에 넣지 않고 음수 큐에 넣는 것이다.

3. 각각의 큐에서 두개의 요소씩 꺼내서 곱한다. 남는것들은 마지막에 처리한다.



---

![image](https://github.com/user-attachments/assets/9783005f-32ee-44db-987a-f086a9ad39a5)

