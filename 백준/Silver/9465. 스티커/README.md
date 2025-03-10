# [Silver I] 스티커 - 9465 

[문제 링크](https://www.acmicpc.net/problem/9465) 

### 성능 요약

메모리: 110700 KB, 시간: 624 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 10일 18:02:38

### 문제 설명

<p>상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다. 스티커는 그림 (a)와 같이 2행 n열로 배치되어 있다. 상냥이는 스티커를 이용해 책상을 꾸미려고 한다.</p>

<p>상냥이가 구매한 스티커의 품질은 매우 좋지 않다. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다. 즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/sticker.png" style="height:150px; width:575px"></p>

<p>모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다. 먼저, 그림 (b)와 같이 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하시오. 즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.</p>

<p>위의 그림의 경우에 점수가 50, 50, 100, 60인 스티커를 고르면, 점수는 260이 되고 이 것이 최대 점수이다. 가장 높은 점수를 가지는 두 스티커 (100과 70)은 변을 공유하기 때문에, 동시에 뗄 수 없다.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 n (1 ≤ n ≤ 100,000)이 주어진다. 다음 두 줄에는 n개의 정수가 주어지며, 각 정수는 그 위치에 해당하는 스티커의 점수이다. 연속하는 두 정수 사이에는 빈 칸이 하나 있다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다. </p>

### 출력 

 <p>각 테스트 케이스 마다, 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값을 출력한다.</p>

---

DP, 규칙찾기

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            
            for(int i=2; i<=n; i++) {
                dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + arr[0][i];
                
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }
            
            
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        } 
        
    }
    
}


```
처음엔 구현으로 풀려고 했는데 코드가 장황해지고 반례 케이스들을 못잡는 경우가 많이 생겼다.

DP 접근 방식으로 풀면 더 깔끔하고 규칙성있게 풀 수 있는 문제다.

---

![image](https://github.com/user-attachments/assets/992f6da2-9158-4242-aeeb-a61db3eaf649)

![image](https://github.com/user-attachments/assets/e58decaa-6c71-406c-83c0-9e3222ca4034)
