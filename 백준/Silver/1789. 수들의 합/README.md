# [Silver V] 수들의 합 - 1789 

[문제 링크](https://www.acmicpc.net/problem/1789) 

### 성능 요약

메모리: 14256 KB, 시간: 108 ms

### 분류

그리디 알고리즘, 수학

### 제출 일자

2024년 12월 23일 17:38:47

### 문제 설명

<p>서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?</p>

### 입력 

 <p>첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.</p>

### 출력 

 <p>첫째 줄에 자연수 N의 최댓값을 출력한다.</p>

---

그리디 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        long n = Long.parseLong(br.readLine());
        
        long sum = 0, ans = 0;
        
        for(int i=1; ; i++) {
            sum += i;
            ans++;
            if(sum > n) {
                System.out.print(ans - 1);
                return;
            }
        }
        
    }
    
}


```

---

![13](https://github.com/user-attachments/assets/d4973259-e9f7-452d-be7c-3cc2f7e7f4ee)

---

![image](https://github.com/user-attachments/assets/27906352-f7c9-448f-85e4-5c5edb4e2faf)

