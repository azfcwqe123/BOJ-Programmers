# [Silver V] 팩토리얼 분해 - 2057 

[문제 링크](https://www.acmicpc.net/problem/2057) 

### 성능 요약

메모리: 16132 KB, 시간: 132 ms

### 분류

브루트포스 알고리즘, 그리디 알고리즘, 수학

### 제출 일자

2025년 1월 26일 14:46:13

### 문제 설명

<p>음 아닌 정수 N이 주어졌을 때, 이 수를 서로 다른 정수 M(M ≥ 1)개의 팩토리얼의 합으로 나타낼 수 있는지 알아내는 프로그램을 작성하시오. 예를 들어 2=0!+1!로 나타낼 수 있지만, 5는 이와 같은 방식으로 나타낼 수 없다.</p>

### 입력 

 <p>첫째 줄에 정수 N이 주어진다.</p>

### 출력 

 <p>입력으로 주어진 수를 서로 다른 정수 M개의 팩토리얼의 합으로 나타낼 수 있으면 YES, 없으면 NO를 출력한다. </p>

---

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        long n = Long.parseLong(br.readLine());
        long[] arr = new long[20];
        
        if(n == 0) {
            System.out.print("NO");
            System.exit(0);
        }
        
        arr[0] = 1L;
        
        for(int i=1; i<=19; i++) arr[i] = arr[i-1] * i; // 팩토리얼 배열 생성
        
        for(int i=19; i>=0; i--) {
            if(n >= arr[i]) n -= arr[i];
            
            if(n == 0) {
                System.out.print("YES");
                System.exit(0);
            }
        }
        
        System.out.print("NO");
    }
    
}

```

![image](https://github.com/user-attachments/assets/0c4ab9aa-e09b-44a5-b701-20a0a5d3eb8c)

1. n의 범위는 20! 미만인걸 알 수 있으니, 배열에는 19!까지만 담아도 충분하다.

2. 큰수에서부터 빼줘야한다. 그러면 알아서 조합이 맞춰진다.

---

참고: https://stdio-han.tistory.com/181

![image](https://github.com/user-attachments/assets/e8525275-5edd-4b8c-a2ed-bf00351d2959)
