# [Gold IV] 여행 가자 - 1976 

[문제 링크](https://www.acmicpc.net/problem/1976) 

### 성능 요약

메모리: 17316 KB, 시간: 160 ms

### 분류

자료 구조, 분리 집합, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 8일 13:57:58

### 문제 설명

<p>동혁이는 친구들과 함께 여행을 가려고 한다. 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다. 동혁이의 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자. 물론 중간에 다른 도시를 경유해서 여행을 할 수도 있다. 예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고, 동혁이의 여행 계획이 E C B C D 라면 E-A-B-C-B-C-B-D라는 여행경로를 통해 목적을 달성할 수 있다.</p>

<p>도시들의 개수와 도시들 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성하시오. 같은 도시를 여러 번 방문하는 것도 가능하다.</p>

### 입력 

 <p>첫 줄에 도시의 수 N이 주어진다. N은 200이하이다. 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다. M은 1000이하이다. 다음 N개의 줄에는 N개의 정수가 주어진다. i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다. 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다. A와 B가 연결되었으면 B와 A도 연결되어 있다. 마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.</p>

### 출력 

 <p>첫 줄에 가능하면 YES 불가능하면 NO를 출력한다.</p>

---

유니온 파인드

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] unf;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        unf = new int[n+1];
        
        for(int i=1; i<=n; i++) unf[i] = i;
        
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                int ch = Integer.parseInt(st.nextToken());
                if(ch == 1) Union(i, j);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Find(Integer.parseInt(st.nextToken())); // 시작점
        for(int i=1; i<m; i++) {
            int now = Integer.parseInt(st.nextToken()); // 시작점과 모두 연결돼있어야함
            
            if(start != Find(now)) {
                System.out.print("NO");
                System.exit(0);
            }
        }
        
        System.out.print("YES");
        
    } 
    
    static void Union(int i, int j) {
        
        int fa = Find(i);
        int fb = Find(j);
        
        if(fa != fb) unf[fa] = fb;
    }
    
    static int Find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = Find(unf[v]);
    }
}


```

---

![image](https://github.com/user-attachments/assets/8f5358d9-477b-400e-8003-e6bd0ff25925)
