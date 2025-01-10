# [Silver II] 촌수계산 - 2644 

[문제 링크](https://www.acmicpc.net/problem/2644) 

### 성능 요약

메모리: 14128 KB, 시간: 100 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2025년 1월 10일 14:00:13

### 문제 설명

<p>우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.</p>

<p>여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.</p>

### 입력 

 <p>사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.</p>

<p>각 사람의 부모는 최대 한 명만 주어진다.</p>

### 출력 

 <p>입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.</p>

---

DFS, 그래프 탐색

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static int n, m, start, end;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(br.readLine());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        DFS(start, 0); // 시작을 start부터
        System.out.print(-1);
    }
    
    public static void DFS(int start, int cnt) {
        
        if(start == end) {
            System.out.print(cnt);
            System.exit(0);
        }
        
        for(int nv : graph.get(start)) {
            if(!visited[nv]) { // 방문 체크 여부가 없다면 양방향 그래프이기 때문에 무한 루프를 돌게 된다.
                visited[nv] = true;
                DFS(nv, cnt + 1);
            }
        }
        
    }
}


```

---

BFS, 그래프 탐색

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static int n, m, start, end;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] dist;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        dist = new int[n+1];
        visited = new boolean[n+1];
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(br.readLine());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        System.out.print(BFS(start));
    }
    
    public static int BFS(int start) {
        
        Queue<Integer> Q = new LinkedList<>();
        visited[start] = true;
        Q.offer(start);
        
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            
            for(int i=0; i<graph.get(cur).size(); i++) {
                int k = graph.get(cur).get(i);
                if(!visited[k]) {
                    dist[k] = dist[cur] + 1;
                    if(k == end) {
                        return dist[k];
                    }
                    Q.offer(k);
                    visited[k] = true;
                }
            }
        }
        
        return -1;
    }
}


```

---

![image](https://github.com/user-attachments/assets/7a60222e-ba64-44d0-9bbe-6f9992914fe5)
