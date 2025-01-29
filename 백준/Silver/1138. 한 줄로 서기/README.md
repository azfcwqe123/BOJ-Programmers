# [Silver II] 한 줄로 서기 - 1138 

[문제 링크](https://www.acmicpc.net/problem/1138) 

### 성능 요약

메모리: 15792 KB, 시간: 120 ms

### 분류

그리디 알고리즘, 구현

### 제출 일자

2025년 1월 29일 15:25:50

### 문제 설명

<p>N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.</p>

<p>어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다. 그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.</p>

<p>사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.</p>

<p>각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 사람의 수 N이 주어진다. N은 10보다 작거나 같은 자연수이다. 둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다. i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.</p>

### 출력 

 <p>첫째 줄에 줄을 선 순서대로 키를 출력한다.</p>

---

직접 구현, 그리디 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int k = Integer.parseInt(st.nextToken()); // k와 i를 매칭시킴. i=1 k=2, i=2 k=1, i=3 k=1, i=4 k=0
            int cnt = 0; // 왼쪽부터 자신보다 큰 사람의 수.
            
            for(int j=0; j<n; j++) {
                if(arr[j] != 0) continue; // 자리가 있는 곳은 PASS
                
                if(arr[j] == 0) { // 자신보다 큰 사람이 있을 자리
                    cnt++;
                    if(k+1 == cnt) arr[j] = i; // 자신보다 큰 사람의 수 + 1이 되면 그땐 빈자리라 착석
                }
            }
            
        }
        
        for(int x : arr) sb.append(x + " ");
        
        System.out.print(sb);
    }
}


```

---

배열리스트 이용

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=n; i>0; i--) {
            list.add(arr[i], i);
        }
        
        for(int x : list) System.out.print(x + " ");
    }
}


```

---

![image](https://github.com/user-attachments/assets/1c6873f0-78bb-4caa-9736-f843a91630bd)
