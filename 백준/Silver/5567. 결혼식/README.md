# [Silver II] 결혼식 - 5567 

[문제 링크](https://www.acmicpc.net/problem/5567) 

### 성능 요약

메모리: 18576 KB, 시간: 156 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 10일 13:09:06

### 문제 설명

<p>상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.</p>

<p>상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다. 다음 줄부터 m개 줄에는 친구 관계 a<sub>i</sub> b<sub>i</sub>가 주어진다. (1 ≤ a<sub>i</sub> < b<sub>i</sub> ≤ n) a<sub>i</sub>와 b<sub>i</sub>가 친구라는 뜻이며, b<sub>i</sub>와 a<sub>i</sub>도 친구관계이다. </p>

### 출력 

 <p>첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.</p>

---

그래프 탐색

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] ch;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        ch = new boolean[n+1];
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        DFS(1, 0);
        
        int ans = 0;
        
        for(int i=2; i<ch.length; i++) {
            if(ch[i]) ans++;
        }
        
        System.out.print(ans);
    }
    
    public static void DFS(int v, int cnt) {
        
        if(cnt == 2) return; // 친구의 친구의 친구부터는 제외
        
        for(int nv : graph.get(v)) {
            ch[nv] = true;
            DFS(nv, cnt + 1);
        } 
    }
}


```

---

틀렸던 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] ch;
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        ch = new boolean[n+1];
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        
        DFS(1, 0);
        
        int sum = 0;
        
        for(boolean TF : ch) {
            if(TF) sum++;
        }
        
        System.out.print(sum - 1);
    }
    
    public static void DFS(int v, int cnt) {
        
        if(cnt > 2) return;
        
        ch[v] = true;
        
        for(int nv : graph.get(v)) {
            DFS(nv, cnt + 1);
        } 
    }
}


```

양방향 그래프를 이용해야하는데 단일 방향으로 실수했고, DFS 그래프 탐색을 할 때, if(cnt > 2) 부분을 잘못 활용함

---

![image](https://github.com/user-attachments/assets/8eab262f-81c9-4aca-ae6f-ec7ac1a985fd)
