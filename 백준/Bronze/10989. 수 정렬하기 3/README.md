# [Bronze I] 수 정렬하기 3 - 10989 

[문제 링크](https://www.acmicpc.net/problem/10989) 

### 성능 요약

메모리: 336796 KB, 시간: 1532 ms

### 분류

정렬

### 제출 일자

2024년 12월 27일 20:03:10

### 문제 설명

<p>N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.</p>

---
카운팅 정렬

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static int[] cnt = new int[10001];
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        while(n-- > 0) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=10000; i++) {
            
            while(cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        
        System.out.print(sb);
        
    }
    
}

```

---

![image](https://github.com/user-attachments/assets/7289235a-babc-438e-8e8b-3f22cb64b07c)
