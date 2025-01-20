# [Silver IV] 기타줄 - 1049 

[문제 링크](https://www.acmicpc.net/problem/1049) 

### 성능 요약

메모리: 14232 KB, 시간: 104 ms

### 분류

그리디 알고리즘, 수학

### 제출 일자

2025년 1월 20일 12:56:27

### 문제 설명

<p>Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다. 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다. 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.</p>

<p>끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.</p>

---

그리디 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int pack = 1001, each = 1001;
        
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            each = Math.min(each, Integer.parseInt(st.nextToken()));
        }
        
        int ans = 0;
        
        ans = Math.min((n / 6 + 1) * pack, n * each); // 패키지 구매 vs 낱개 구매 
        
        ans = Math.min((n / 6) * pack + (n % 6) * each, ans); // 혼합 구매 vs (패키지 구매 or 낱개 구매)
        
        System.out.print(ans);
    }
    
}


```

핵심: 1. 패키지 구매 2. 낱개 구매 3. 혼합 구매 케이스를 모두 고려해야 풀 수 있는 문제다.

첫번째 틀렸던 이유는, 1번과 3번만 고려해서 틀렸다. 당연히 낱개로 전체를 구매하는건 비쌀거라는 오판을 해버렸기에 틀렸었다.

![image](https://github.com/user-attachments/assets/46e79cae-5be1-4f40-83b9-eda7e7b236c5)
