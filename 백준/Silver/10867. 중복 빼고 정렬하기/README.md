# [Silver V] 중복 빼고 정렬하기 - 10867 

[문제 링크](https://www.acmicpc.net/problem/10867) 

### 성능 요약

메모리: 27228 KB, 시간: 420 ms

### 분류

정렬

### 제출 일자

2024년 12월 23일 13:33:30

### 문제 설명

<p>N개의 정수가 주어진다. 이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 같은 정수는 한 번만 출력한다.</p>

### 입력 

 <p>첫째 줄에 수의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 수를 오름차순으로 정렬한 결과를 출력한다. 이때, 같은 수는 한 번만 출력한다.</p>

---

트리셋
```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) set.add(Integer.parseInt(st.nextToken()));
        
        for(int x : set) System.out.print(x + " ");
    }
    
}


```

---


![image](https://github.com/user-attachments/assets/d03b4fb0-ae44-4ee5-ad0f-9099676ee8c1)
