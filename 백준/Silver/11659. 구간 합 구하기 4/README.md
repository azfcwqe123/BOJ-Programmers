# [Silver III] 구간 합 구하기 4 - 11659 

[문제 링크](https://www.acmicpc.net/problem/11659) 

### 성능 요약

메모리: 52524 KB, 시간: 484 ms

### 분류

누적 합

### 제출 일자

2024년 12월 21일 19:30:47

### 문제 설명

<p>수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.</p>

### 출력 

 <p>총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.</p>

---

누적합 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        
        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(sum[b] - sum[a-1]).append('\n');
        }
        
        System.out.print(sb);
        
    }
}

```

이런 문제는 슬라이딩 윈도우로 풀기엔 번거롭고 시간 복잡도도 좋지 않기에 누적합 알고리즘으로 푸는게 가장 좋은것 같다.

---

수정 부분

```java
for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
for(int i=1; i<=N; i++) sum[i] = sum[i-1] + arr[i];
```

->

```java
for(int i=1; i<=N; i++) {
     arr[i] = Integer.parseInt(st.nextToken());
     sum[i] = sum[i-1] + arr[i];
}
```

두개의 for문을 굳이 분리시킬 필요가 없어서 합쳤더니, 대략 200ms정도 시간이 차이가 났다.

---

![image](https://github.com/user-attachments/assets/9f27fa7c-2a52-473e-b0a7-5c28a6659101)
