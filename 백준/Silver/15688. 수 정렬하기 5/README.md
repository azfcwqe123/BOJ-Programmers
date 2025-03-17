# [Silver V] 수 정렬하기 5 - 15688 

[문제 링크](https://www.acmicpc.net/problem/15688) 

### 성능 요약

메모리: 100760 KB, 시간: 16336 ms

### 분류

정렬

### 제출 일자

2025년 3월 17일 21:20:41

### 문제 설명

<p>N개의 수가 주어졌을 때, 이를 비내림차순으로 정렬하는 프로그램을 작성하시오.</p>

<p>길이가 K인 수열 A가 A<sub>1</sub> ≤ A<sub>2</sub> ≤ ... ≤ A<sub>K-1</sub> ≤ A<sub>K</sub>를 만족하면, 비내림차순이라고 한다.</p>

### 입력 

 <p>첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이며, 같은 수가 여러 번 중복될 수도 있다.</p>

### 출력 

 <p>첫째 줄부터 N개의 줄에 비내림차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.</p>

---

카운팅 정렬

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final int max = 1_000_000;
    static int[] arr = new int[2 * max + 1];
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            arr[k + max]++;
        }
        
        for(int i=0; i<=2*max; i++) { // i=1로 처음에 잡는 바람에 한번 틀렸음. i=0인경우는 -1000000임.
            if(arr[i] == 0) continue;
            else run(i);
        }
        
        System.out.print(sb);
    }
    
    static void run(int i) {
        while(arr[i] > 0) {
            sb.append(i - max).append('\n');
            arr[i]--;
        }
    }
}


```

---

![image](https://github.com/user-attachments/assets/128ff12d-c370-4a53-98a2-4a7c24ace53c)
