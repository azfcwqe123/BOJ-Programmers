# [Silver II] 트리의 부모 찾기 - 11725 

[문제 링크](https://www.acmicpc.net/problem/11725) 

### 성능 요약

메모리: 73972 KB, 시간: 504 ms

### 분류

그래프 이론, 그래프 탐색, 트리, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2025년 2월 3일 00:10:19

### 문제 설명

<p>루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.</p>

### 출력 

 <p>첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.</p>

---

문제에서 최상위노드를 1이라고 알려준게 핵심

DFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        parent = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        DFS(1);
        
        for(int i=2; i<=n; i++) sb.append(parent[i]).append('\n'); // 루트 노드 제외 나머지 노드의 부모들 찾기
        
        System.out.print(sb);
    }
    
    static void DFS(int n) {
        
        visited[n] = true;
        
        for(int x : list.get(n)) {
            if(!visited[x]) {
                visited[x] = true;
                parent[x] = n; // 부모 체크
                DFS(x);
            }
        }
    }
}


```

---

BFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        parent = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        BFS(1);
        
        for(int i=2; i<=n; i++) sb.append(parent[i]).append('\n');
        
        System.out.print(sb);
    }
    
    static void BFS(int n) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(n);
        visited[n] = true;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            
            for(int x : list.get(cur)) {
                if(!visited[x]) {
                    Q.offer(x);
                    visited[x] = true;
                    parent[x] = cur;
                }
            }
        }
        
    }
}


```

---

![image](https://github.com/user-attachments/assets/2ae6408b-7192-4bb2-a1bd-b7025675ec7a)
