# [Silver II] 연결 요소의 개수 - 11724 

[문제 링크](https://www.acmicpc.net/problem/11724) 

### 성능 요약

메모리: 116940 KB, 시간: 456 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 12월 30일 16:44:29

### 문제 설명

<p>방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.</p>

### 출력 

 <p>첫째 줄에 연결 요소의 개수를 출력한다.</p>

---

DFS 풀이, 456ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static int[][] graph;
    public static boolean[] visited;
    public static int n, m, ans = 0;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a][b] = graph[b][a] = 1;
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) { // 핵심
                DFS(i);
                ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void DFS(int v) {
        
        visited[v] = true;
        
        for(int i=1; i<=n; i++) {
            if(graph[v][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
        
    }
    
}

```

---

DFS + 인접리스트 사용, 632ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int n, m, ans = 0;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) { // 핵심
                DFS(i);
                ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void DFS(int v) {
        
        visited[v] = true;
        
        for(int nv : graph.get(v)) {
            if(!visited[nv]) {
                DFS(nv);
            }
        }
        
    }
    
}

```

---

BFS + 인접리스트 사용, 568ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static int n, m, ans = 0;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        
        visited = new boolean[n+1];
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                BFS(i);
                ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
    public static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        visited[v] = true;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            
            for(int nv : graph.get(cur)) {
                if(!visited[nv]) {
                    Q.offer(nv);
                    visited[nv] = true;
                }
            }
        }
        
    }
    
}




```

---

![image](https://github.com/user-attachments/assets/a0e05a8d-858d-499e-927f-743f3304493d)
