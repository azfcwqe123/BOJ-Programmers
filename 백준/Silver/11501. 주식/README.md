# [Silver II] 주식 - 11501 

[문제 링크](https://www.acmicpc.net/problem/11501) 

### 성능 요약

메모리: 316400 KB, 시간: 1124 ms

### 분류

그리디 알고리즘

### 제출 일자

2025년 1월 28일 15:26:57

### 문제 설명

<p>홍준이는 요즘 주식에 빠져있다. 그는 미래를 내다보는 눈이 뛰어나, 날 별로 주가를 예상하고 언제나 그게 맞아떨어진다. 매일 그는 아래 세 가지 중 한 행동을 한다.</p>

<ol>
	<li>주식 하나를 산다.</li>
	<li>원하는 만큼 가지고 있는 주식을 판다.</li>
	<li>아무것도 안한다.</li>
</ol>

<p>홍준이는 미래를 예상하는 뛰어난 안목을 가졌지만, 어떻게 해야 자신이 최대 이익을 얻을 수 있는지 모른다. 따라서 당신에게 날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산을 해달라고 부탁했다.</p>

<p>예를 들어 날 수가 3일이고 날 별로 주가가 10, 7, 6일 때, 주가가 계속 감소하므로 최대 이익은 0이 된다. 그러나 만약 날 별로 주가가 3, 5, 9일 때는 처음 두 날에 주식을 하나씩 사고, 마지막날 다 팔아 버리면 이익이 10이 된다.</p>

### 입력 

 <p>입력의 첫 줄에는 테스트케이스 수를 나타내는 자연수 T가 주어진다. 각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고, 둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 날 별 주가는 10,000이하다.</p>

### 출력 

 <p>각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력한다. 답은 부호있는 64bit 정수형으로 표현 가능하다.</p>

---

그리디 알고리즘

첫번째 풀이(시간 초과)

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
            int[] price = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) price[i] = Integer.parseInt(st.nextToken());
            
            sb.append(solution(n, price)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int solution(int n, int[] price) {
        
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(price[j] < price[i]) {
                    ans += price[i] - price[j];
                    price[j] = price[i];
                }
            }
        }
        
        return ans;
    } 
}
```

---

두번째 풀이, 역탐색

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
            int[] arr = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
            
            long ans = 0, max = 0;
            
            for(int j=arr.length-1; j>=0; j--) {
                if(max < arr[j]) max = arr[j];
                else ans += max - arr[j];
            }
            
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}

```

---

![image](https://github.com/user-attachments/assets/534aea89-4271-4d48-b9aa-1ba4adcb472a)
