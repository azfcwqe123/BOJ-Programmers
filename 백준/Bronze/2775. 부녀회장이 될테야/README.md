# [Bronze I] 부녀회장이 될테야 - 2775 

[문제 링크](https://www.acmicpc.net/problem/2775) 

### 성능 요약

메모리: 14060 KB, 시간: 100 ms

### 분류

다이나믹 프로그래밍, 구현, 수학

### 제출 일자

2024년 12월 27일 21:49:13

### 문제 설명

<p>평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.</p>

<p>이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.</p>

<p>아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.</p>

### 입력 

 <p>첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다</p>

### 출력 

 <p>각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.</p>

---

dp

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        int[][] apt = new int[15][15];
        
        for(int i=0; i<15; i++) {
            apt[i][1] = 1;
            apt[0][i] = i;
        }
        
        for(int i=1; i<15; i++) {
            
            for(int j=2; j<15; j++) {
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
        
        while(T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            
            System.out.println(apt[a][b]);
        }
        
    }
    
}


```

---

참고 블로그 : https://st-lab.tistory.com/78

![image](https://github.com/user-attachments/assets/529427b6-8e63-47d9-b397-acc3059eb218)
