# [Silver III] 두 수의 합 - 3273 

[문제 링크](https://www.acmicpc.net/problem/3273) 

### 성능 요약

메모리: 31264 KB, 시간: 360 ms

### 분류

정렬, 두 포인터

### 제출 일자

2024년 12월 2일 20:26:37

### 문제 설명

<p>n개의 서로 다른 양의 정수 a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub>으로 이루어진 수열이 있다. a<sub>i</sub>의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 자연수 x가 주어졌을 때, a<sub>i</sub> + a<sub>j</sub> = x (1 ≤ i < j ≤ n)을 만족하는 (a<sub>i</sub>, a<sub>j</sub>)쌍의 수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)</p>

### 출력 

 <p>문제의 조건을 만족하는 쌍의 개수를 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    int[] arr = new int[n];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    int x = Integer.parseInt(br.readLine());
	    
	    int lt = 0, rt = n-1;
	    
	    int cnt = 0;
	    
	    while(lt < rt) {
	        
	        int sum = arr[lt] + arr[rt];
	        
	        if(sum == x) {
	            cnt++;
	            lt++;
	            rt--;
	        }
	        else if(sum < x) lt++;
	        else if(sum > x) rt--;
	    }
	    
	    System.out.print(cnt);
	    
    }
    
}

```

---

수를 정렬하고

1 2 3 5 7 9 10 11 12가 됐다고 가정했을때,

lt와 rt을 함께 앞에서부터 돌면 합의 쌍이 지어지지 않는다. 

lt을 맨 앞에, rt을 맨 끝에 두고 시작해야 합의 쌍이 지어진다.
