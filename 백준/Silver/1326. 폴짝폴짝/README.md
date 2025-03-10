# [Silver II] 폴짝폴짝 - 1326 

[문제 링크](https://www.acmicpc.net/problem/1326) 

### 성능 요약

메모리: 15644 KB, 시간: 156 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 10일 12:35:48

### 문제 설명

<p>개구리가 일렬로 놓여 있는 징검다리 사이를 폴짝폴짝 뛰어다니고 있다. 징검다리에는 숫자가 각각 쓰여 있는데, 이 개구리는 매우 특이한 개구리여서 어떤 징검다리에서 점프를 할 때는 그 징검다리에 쓰여 있는 수의 배수만큼 떨어져 있는 곳으로만 갈 수 있다.</p>

<p>이 개구리는 a번째 징검다리에서 b번째 징검다리까지 가려고 한다. 이 개구리가 a번째 징검다리에서 시작하여 최소 몇 번 점프를 하여 b번째 징검다리까지 갈 수 있는지를 알아보는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 징검다리의 개수 N(1≤N≤10,000)이 주어지고, 이어서 각 징검다리에 쓰여 있는 N개의 정수가 주어진다. 그 다음 줄에는 N보다 작거나 같은 자연수 a, b가 주어지는 데, 이는 개구리가 a번 징검다리에서 시작하여 b번 징검다리에 가고 싶다는 뜻이다. 징검다리에 쓰여있는 정수는 10,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 개구리가 a번 징검다리에서 b번 징검다리로 최소 몇 번 점프하여 갈 수 있는 지를 출력하시오. a에서 b로 갈 수 없는 경우에는 -1을 출력한다.</p>

---

BFS 활용

```java
import java.util.*;
import java.io.*;

// 개구리 클래스 생성
class Frog {
    
    int pos;
    int count;
    
    public Frog(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int[] bridge;
    public static int n;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        bridge = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        System.out.print(BFS(start, end));
    }
    
    public static int BFS(int start, int end) {
        
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        
        Queue<Frog> Q = new LinkedList<>();
        Q.offer(new Frog(start, 0));
        
        while(!Q.isEmpty()) {
            Frog cur = Q.poll();
            
            if(cur.pos == end) return cur.count;
            
            int jump = bridge[cur.pos];
            
            // 뒤로
            for(int i=cur.pos; i>=1; i -= jump) {
                if(visited[i]) continue;
                visited[i] = true;
                Q.offer(new Frog(i, cur.count + 1));
            }
            
            // 앞으로
            for(int i=cur.pos; i<=n; i += jump) {
                if(visited[i]) continue;
                visited[i] = true;
                Q.offer(new Frog(i, cur.count + 1));
            }
            
        }
        
        return -1;
    }
}


```

---

참고 블로그 : https://akys159357.tistory.com/431
![image](https://github.com/user-attachments/assets/92f739a7-fc01-431a-b953-84556dc847ea)
