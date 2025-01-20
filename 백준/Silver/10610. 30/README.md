# [Silver IV] 30 - 10610 

[문제 링크](https://www.acmicpc.net/problem/10610) 

### 성능 요약

메모리: 16472 KB, 시간: 156 ms

### 분류

그리디 알고리즘, 수학, 정수론, 정렬, 문자열

### 제출 일자

2025년 1월 20일 12:31:01

### 문제 설명

<p>어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.</p>

<p>미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.</p>

### 입력 

 <p>N을 입력받는다. N는 최대 10<sup>5</sup>개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.</p>

### 출력 

 <p>미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.</p>

---

그리디 알고리즘, 정수론

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        char[] arr = br.readLine().toCharArray();
        
        Arrays.sort(arr);
        
        int sum = 0;
        for(int i = arr.length-1; i>=0; i--) {
            sum += arr[i] - '0';
            sb.append(arr[i]);
        }
        
        if(sum % 3 == 0 && arr[0] == '0') {
            System.out.print(sb);
            return;
        }
        
        System.out.print(-1);
    }
    
}


```

30의 배수가 되려면, 각 자리의 숫자 합이 3의 배수이고 마지막 숫자가 0이면은 30의 배수가 된다.

---

참고블로그: https://myeongju00.tistory.com/102

![image](https://github.com/user-attachments/assets/f3964b28-9675-4c3c-a1bb-d81c46318e5d)
