# [Gold IV] 숨바꼭질 4 - 13913 

[문제 링크](https://www.acmicpc.net/problem/13913) 

### 성능 요약

메모리: 37944 KB, 시간: 304 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 2일 22:51:47

### 문제 설명

<p>수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.</p>

<p>수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.</p>

### 출력 

 <p>첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.</p>

<p>둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.</p>

---

BFS, 역추적

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, time = 0;
    static boolean[] visited = new boolean[100_001];
    static int[] parent = new int[100_001];
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        BFS();
        
        Stack<Integer> stack = new Stack<>();
        
        int idx = k;
        stack.push(k);

        // 선입후출인 스택을 사용
        while(idx != n) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }
        
        sb.append(time).append("\n");
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        
        System.out.print(sb);
    }
    
    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                int cur = Q.poll();
                
                if(cur == k) return;
                
                int[] move = {cur * 2, cur + 1, cur - 1};
                
                for(int d=0; d<3; d++) {
                    if(rangeCheck(move[d]) && !visited[move[d]]) {
                        visited[move[d]] = true;
                        Q.offer(move[d]);
                        parent[move[d]] = cur; // 부모 저장
                    }
                }
            }
            
            time++;
        }
        
    }
    
    static boolean rangeCheck(int cur) {
        return 0 <= cur && cur <=100_000;
    }
}


```

---

![image](https://github.com/user-attachments/assets/3bd5525c-233f-4cba-9a88-e7220ce49c6f)

