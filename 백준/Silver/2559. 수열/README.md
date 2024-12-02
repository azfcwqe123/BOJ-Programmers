# [Silver III] 수열 - 2559 

[문제 링크](https://www.acmicpc.net/problem/2559) 

### 성능 요약

메모리: 23620 KB, 시간: 232 ms

### 분류

누적 합, 슬라이딩 윈도우, 두 포인터

### 제출 일자

2024년 12월 2일 20:18:03

### 문제 설명

<p>매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.</p>

<p>예를 들어, 아래와 같이 10일 간의 온도가 주어졌을 때, </p>

<p>3 -2 -4 -9 0 3 7 13 8 -3</p>

<p>모든 연속적인 이틀간의 온도의 합은 아래와 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/563b6bfd-12ff-4275-a869-90fdd43b6deb/-/preview/" style="width: 259px; height: 73px;"></p>

<p>이때, 온도의 합이 가장 큰 값은 21이다. </p>

<p>또 다른 예로 위와 같은 온도가 주어졌을 때, 모든 연속적인 5일 간의 온도의 합은 아래와 같으며, </p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/cb8d846c-2f90-475a-8901-1fb69de87397/-/preview/" style="height: 80px; width: 259px;"></p>

<p>이때, 온도의 합이 가장 큰 값은 31이다.</p>

<p>매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램을 작성하시오. </p>

### 입력 

 <p>첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다. 첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다. N은 2 이상 100,000 이하이다. 두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다. K는 1과 N 사이의 정수이다. 둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -100 이상 100 이하이다. </p>

### 출력 

 <p>첫째 줄에는 입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력한다.</p>

---

누적합 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n+1];
	    int[] sum = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1; i<=n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i=1; i<=n; i++) {
	        sum[i] = sum[i-1] + arr[i];
	    }
	    
	    int max = Integer.MIN_VALUE;
	    
	    for(int i=0; i<n-k+1; i++) {
	        max = Math.max(max, sum[k+i] - sum[i]);
	    }
	    
	    System.out.print(max);
	    
	    
    }
    
}

```

---

슬라이딩 윈도우 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int sum = 0, max = 0;
	    
	    for(int i=0; i<n; i++) {
	        
	        sum += arr[i];
	        
	        if(i == k-1) max = sum;
	        
	        else if(i >= k) {
	            sum -= arr[i-k];
	            max = Math.max(max, sum);
	        }
	        
	    }
	    
	    System.out.print(max);
    }
    
}

```

---

투포인터 풀이(?)

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int sum = 0;
	    
	    for(int i=0; i<k; i++) {
	        sum += arr[i];
	    }
	    
	    int max = sum;
	    
	    int lt = 0, rt = k;
	    
	    while(rt < n) {
	        
	        sum += arr[rt++] - arr[lt++];
	        
	        max = Math.max(max, sum);
	        
	    }
	    
	    System.out.print(max);
    }
    
}

```
