# [Silver I] 숨바꼭질 - 1697 

[문제 링크](https://www.acmicpc.net/problem/1697) 

### 성능 요약

메모리: 23344 KB, 시간: 156 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 14일 12:53:26

### 문제 설명

<p>수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.</p>

<p>수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.</p>

### 출력 

 <p>수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.</p>

---

BFS 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int n, k;
    public static int[] visited = new int[100_001];
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.print((n == k) ? 0 : BFS(n));
    }
    
    public static int BFS(int n) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                int cur = Q.poll();    
                
                int[] move = {cur-1, cur+1, cur*2}; 
                        
                for(int j=0; j<3; j++) {
                    
                    if(!rangeCheck(move[j])) continue; // 범위 체크
                    
                    else if(move[j] == k) return cnt + 1; // 동생을 찾았다면
                    
                    else if(visited[move[j]] == 0) { // 찾지 못했다면 방문 체크
                        visited[move[j]] = 1;
                        Q.offer(move[j]);
                    }
                }
            }
            cnt++; 
        }
        
        return cnt;
    }
    
    public static boolean rangeCheck(int move) {
        return move >= 0 && move <= 100_000;
    } 
    
}


```

---

\- 첫번째 틀린 이유 : 범위 체크를 안 함 -> 런타임 에러
&nbsp;

\- 두번째 틀린 이유 : n과 k가 같을때, 즉 수빈과 동생의 위치가 같을때를 고려 안 함

![image](https://github.com/user-attachments/assets/d27d7c8a-b11d-437e-9b50-4840cb83b6ee)
