# [Silver V] 팩토리얼 0의 개수 - 1676 

[문제 링크](https://www.acmicpc.net/problem/1676) 

### 성능 요약

메모리: 14284 KB, 시간: 104 ms

### 분류

수학

### 제출 일자

2024년 12월 24일 14:37:40

### 문제 설명

<p>N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)</p>

### 출력 

 <p>첫째 줄에 구한 0의 개수를 출력한다.</p>

---

수학적 사고력이 필요함

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        while(n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        
        System.out.print(ans);
    }
        
}


```

---

참고: https://st-lab.tistory.com/165

![image](https://github.com/user-attachments/assets/2b4f89f4-974e-4af4-bd71-7f415f154579)
