# [Silver IV] 상근이의 여행 - 9372 

[문제 링크](https://www.acmicpc.net/problem/9372) 

### 성능 요약

메모리: 55148 KB, 시간: 424 ms

### 분류

그래프 이론, 트리

### 제출 일자

2024년 12월 19일 18:09:07

### 문제 설명

<p>상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다. </p>

<p>하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.</p>

<p>이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 <strong>가장 적은 종류</strong>의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.</p>

<p>상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.</p>

### 입력 

 <p>첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,</p>

<p>각 테스트 케이스마다 다음과 같은 정보가 주어진다.</p>

<ul>
	<li>첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.</li>
	<li>이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ n; a ≠ b) </li>
	<li>주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.</li>
</ul>

### 출력 

 <p>테스트 케이스마다 한 줄을 출력한다.</p>

<ul>
	<li>상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.</li>
</ul>

---

BFS, 그래프

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[][] graph;
    public static int[] ch;
    public static int N, M, L;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            graph = new int[N+1][N+1];
            ch = new int[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());    
            
                graph[a][b] = 1;
                graph[b][a] = 1;
            }    
            
            ch[1] = 1;
            
            BFS();
            
            System.out.println(L - 1);
        }
        
        
    }
    
    public static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        
        L = 0;
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            L++;
            for(int i=1; i<=N; i++) {
                if(graph[cur][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    Q.add(i);
                }
            }
        }
        
    }
    
}


```

---

BFS, 인접리스트

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] ch;
    public static int N, M, ans;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
            
            ch = new int[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());    
            
                graph.get(a).add(b);
                graph.get(b).add(a);
            }    
            
            ans = 0;
            
            ch[1] = 1;
            
            BFS();
            
            System.out.println(ans);

        }
        
        
    }
    
    public static void BFS() {
        
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int x : graph.get(cur)) {
                if(ch[x] == 0) {
                    Q.offer(x);
                    ch[x] = 1;
                    ans++;
                }
            }
        }
        
    }
    
}


```

---

DFS(못풀음, 틀린 풀이)

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] ch;
    public static int N, M, ans;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
            
            ch = new int[N+1];
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());    
            
                graph.get(a).add(b);
                graph.get(b).add(a);
            }    
            
            ans = 0;
            
            ch[1] = 1;
            
            DFS(1);
            
            System.out.println(ans);
        }
        
        
    }
    
    public static void DFS(int v) {
        
        if(v == N) return;
        
        else {
            for(int x : graph.get(v)) {
                if(ch[x] == 0) {
                    ch[x] = 1;
                    ans++;
                    DFS(x);
                }
            }
        }
        
    }
    
}


```

--- 

최소 신장 트리, "주어지는 비행 스케줄은 항상 연결 그래프를 이룬다."

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());    
            }    
            
            System.out.println(N-1);
        }

    }
    
}


```
---

최소신장트리 - 328ms
BFS - 432 ~ 424ms
![image](https://github.com/user-attachments/assets/7a990e39-7382-4857-be6b-be96172d28f1)
