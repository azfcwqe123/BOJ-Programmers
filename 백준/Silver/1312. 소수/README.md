# [Silver V] 소수 - 1312 

[문제 링크](https://www.acmicpc.net/problem/1312) 

### 성능 요약

메모리: 14196 KB, 시간: 112 ms

### 분류

수학

### 제출 일자

2025년 4월 30일 22:15:39

### 문제 설명

<p>피제수(분자) A와 제수(분모) B가 있다. 두 수를 나누었을 때, 소숫점 아래 N번째 자리수를 구하려고 한다. 예를 들어, A=3, B=4, N=1이라면, A÷B=0.75 이므로 출력 값은 7이 된다.</p>

### 입력 

 <p>첫 번째 줄에 A와 B(1 ≤ A, B ≤ 100,000), N(1 ≤ N ≤ 1,000,000)이 공백을 경계로 주어진다.</p>

### 출력 

 <p>A÷B를 했을 때, 소숫점 아래 N번째 수를 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int res = 0;
        
        for(int i=0; i<n; i++) {
            a = (a % b) * 10;
            res = a / b;
        }
        
        System.out.print(res);
        
    }
    
}

```

처음엔 a를 b로 나눈 값을 문자열로 담고, '.'을 기준으로 n만큼 떨어진곳을 탐색하면 될 줄 알았는데, 문자열로 실수의 소숫점 부분들을 모두 담을 수 없기에 런타임 에러가 계속해서 났다.

해결방법은, 직접 손으로 나눗셈을 하면서 규칙을 찾아내는것이었다.

---

![image](https://github.com/user-attachments/assets/b1909169-be8a-4e48-afc4-e2dd2f239981)
