# [Silver II] 가장 긴 증가하는 부분 수열 - 11053 

[문제 링크](https://www.acmicpc.net/problem/11053) 

### 성능 요약

메모리: 14396 KB, 시간: 120 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 11일 20:56:42

### 문제 설명

<p>수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {<strong>10</strong>, <strong>20</strong>, 10, <strong>30</strong>, 20, <strong>50</strong>} 이고, 길이는 4이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.</p>

---
LIS
```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.fill(dp, 1); // 모든 수들은 길이가 1부터 시작하기 때문에, 1로 꼭 설정해줘야함.
        
        int ans = 1; // 생각없이 ans = 0 했다가 틀림. 부분 수열 최소 길이가 1이기 때문에 1로 설정해야함.
        
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
            ans = Math.max(dp[i], ans);
        }
        
        System.out.print(ans);
        
    }
    
}

```

![B1Pr5obfBxqXvhXDJQiupw_250311_211824](https://github.com/user-attachments/assets/bc241494-ac4f-49a4-b1f5-4a99cd599861)

---

![image](https://github.com/user-attachments/assets/82a5d9f9-af95-4505-8672-75403bccba12)
