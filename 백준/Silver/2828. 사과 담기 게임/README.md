# [Silver V] 사과 담기 게임 - 2828 

[문제 링크](https://www.acmicpc.net/problem/2828) 

### 성능 요약

메모리: 14052 KB, 시간: 100 ms

### 분류

그리디 알고리즘, 구현

### 제출 일자

2025년 1월 11일 15:13:52

### 문제 설명

<p>상근이는 오락실에서 바구니를 옮기는 오래된 게임을 한다. 스크린은 N칸으로 나누어져 있다. 스크린의 아래쪽에는 M칸을 차지하는 바구니가 있다. (M<N) 플레이어는 게임을 하는 중에 바구니를 왼쪽이나 오른쪽으로 이동할 수 있다. 하지만, 바구니는 스크린의 경계를 넘어가면 안 된다. 가장 처음에 바구니는 왼쪽 M칸을 차지하고 있다.</p>

<p>스크린의 위에서 사과 여러 개가 떨어진다. 각 사과는 N칸중 한 칸의 상단에서 떨어지기 시작하며, 스크린의 바닥에 닿을때까지 직선으로 떨어진다. 한 사과가 바닥에 닿는 즉시, 다른 사과가 떨어지기 시작한다.</p>

<p>바구니가 사과가 떨어지는 칸을 차지하고 있다면, 바구니는 그 사과가 바닥에 닿을 때, 사과를 담을 수 있다. 상근이는 사과를 모두 담으려고 한다. 이때, 바구니의 이동 거리의 최솟값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 M이 주어진다. (1 ≤ M < N ≤ 10) 둘째 줄에 떨어지는 사과의 개수 J가 주어진다. (1 ≤ J ≤ 20) 다음 J개 줄에는 사과가 떨어지는 위치가 순서대로 주어진다.</p>

### 출력 

 <p>모든 사과를 담기 위해서 바구니가 이동해야 하는 거리의 최솟값을 출력한다.</p>

---

그리디 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        
        int ans = 0;
        int start = 1, end = m;
        
        while(j-- > 0) {
            int apple = Integer.parseInt(br.readLine());

            // 바구니 위치 < 사과 위치
            if(end < apple) {
                int move = apple - end;
                ans += move;
                start += move;
                end = apple;
            }

            // 사과 위치 < 바구니 위치
            else if(apple < start) {
                int move = start - apple;
                ans += move;
                start = apple;
                end -= move;
            }
            
        }
        
        System.out.print(ans);
    }
    
}

```

처음에 문제가 잘 안 풀려서 BFS로 풀어야하나 싶었지만 그러기엔 코드가 복잡해지고 구현하기에도 빡셀것 같다는 생각이 들었다.

그리디하게 생각해서 풀면 쉽게 풀 수 있는 문제였다.

---

참고: https://tussle.tistory.com/941

![image](https://github.com/user-attachments/assets/15e300de-997a-44c6-b7da-630720691694)
