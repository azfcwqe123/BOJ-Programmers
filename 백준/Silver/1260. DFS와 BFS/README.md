# [Silver II] DFS와 BFS - 1260 

[문제 링크](https://www.acmicpc.net/problem/1260) 

### 성능 요약

메모리: 20768 KB, 시간: 236 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 12월 30일 16:15:58

### 문제 설명

<p>그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.</p>

### 출력 

 <p>첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.</p>

---

인접리스트 풀이

```java
import java.util.*;
import java.io.*;


class Main { 
    
    public static int n, m, v;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] ch;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); // 정점
        m = sc.nextInt(); // 간선 개수 
        v = sc.nextInt(); // 탐색 시작
        
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<Integer>());
        
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    
        // 인접 리스트 정렬 : 가장 작은 노드부터 탐색해야하기 때문
        for(ArrayList<Integer> x : graph) {
            Collections.sort(x);
        }
        
        ch = new boolean[n+1];
        DFS(v);
        sb.append('\n');
        
        ch = new boolean[n+1];
        BFS(v);
        
        System.out.print(sb);
    }
    
    public static void DFS(int v) {
        
        ch[v] = true;
        sb.append(v + " ");
        
        for(int nv : graph.get(v)) {
            if(!ch[nv]) {
                DFS(nv);
            }
        }
    }    
        
    public static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        ch[v] = true;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            sb.append(cur + " ");
            
            for(int nv : graph.get(cur)) {
                if(!ch[nv]) {
                    Q.offer(nv);
                    ch[nv] = true;
                }
            }
        }
        
    }
    
}


```

---

배열 풀이

```java
import java.util.*;
import java.io.*;


class Main {

    public static int n, m, start;
    public static int[][] graph;
    public static boolean[] ch;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        
        graph = new int[n+1][n+1];
        ch = new boolean[n+1];
        
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }
        
        DFS(start);
        sb.append('\n');
        
        ch = new boolean[n+1];
        BFS(start);
        
        System.out.print(sb);
        
    }
    
    public static void DFS(int start) {
        
        ch[start] = true;
        sb.append(start + " ");
        
        for(int i=1; i<=n; i++) {
            if(graph[start][i] == 1 && !ch[i]) {
                DFS(i);
            }
        }
    }
    
    public static void BFS(int start) {
        
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        ch[start] = true;
        
        while(!Q.isEmpty()) {
            start = Q.poll();
            sb.append(start + " ");
            
            for(int i=1; i<=n; i++) {
                if(graph[start][i] == 1 && !ch[i]) {
                    Q.add(i);
                    ch[i] = true;
                }
            }
        }
    }
    
}



```

---

시간이 왜 다른사람들보다 느리게 나왔는지 의문이었지만 가독성을 위해서 Scanner을 써서 그런거였다. 236ms는 bufferedReader 풀이

![image](https://github.com/user-attachments/assets/13fc720a-2ebc-42d5-9c7a-7150ffc941dd)
