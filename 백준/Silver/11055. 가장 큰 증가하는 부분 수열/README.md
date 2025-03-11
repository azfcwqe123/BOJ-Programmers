# [Silver II] 가장 큰 증가하는 부분 수열 - 11055 

[문제 링크](https://www.acmicpc.net/problem/11055) 

### 성능 요약

메모리: 14440 KB, 시간: 124 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 12일 01:03:25

### 문제 설명

<p>수열 A가 주어졌을 때, 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가하는 부분 수열은 A = {<strong>1</strong>, 100, <strong>2</strong>, <strong>50</strong>, <strong>60</strong>, 3, 5, 6, 7, 8} 이고, 합은 113이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 합이 가장 큰 증가하는 부분 수열의 합을 출력한다.</p>

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
        
        dp[0] = arr[0]; // 첫번째 원소는 그 자체로 수열의 합
        int max = arr[0];
        
        for(int i=1; i<n; i++) 
            dp[i] = arr[i]; // dp[i]는 최소한 arr[i]부터 시작하는 수열의 합 
            for(int j=i-1; j>=0; j--) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
            max = Math.max(max, dp[i]);
        }
        
        System.out.print(max);
        
    }
    
}


```

![xUUXbUIpsKqiaRNhXshpF4_250312_011449](https://github.com/user-attachments/assets/54404fad-d1af-4245-a83f-68f5ebd97c39)

---

![image](https://github.com/user-attachments/assets/22846ff5-33ad-46be-8f05-06ae79f0654f)


컴파일 에러 이유: 변수를 이상하게 설정함


틀렸습니다 이유: dp[i] = arr[i];을 추가하지 않았다. dp[i]는 최소한 arr[i]부터 시작하는 수열의 합이란걸 깨달았어야 했다.

