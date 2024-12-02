# [Silver V] 배열 합치기 - 11728 

[문제 링크](https://www.acmicpc.net/problem/11728) 

### 성능 요약

메모리: 317752 KB, 시간: 1472 ms

### 분류

정렬, 두 포인터

### 제출 일자

2024년 12월 2일 16:14:15

### 문제 설명

<p>정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)</p>

<p>둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 10<sup>9</sup>보다 작거나 같은 정수이다.</p>

### 출력 

 <p>첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;


class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    int[] arr1 = new int[n];
	    int[] arr2 = new int[m];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr1[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<m; i++) {
	        arr2[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    int p1 = 0, p2 = 0;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(p1 < n && p2 < m) {
	        
	        if(arr1[p1] < arr2[p2]) sb.append(arr1[p1++] + " ");
	        else sb.append(arr2[p2++] + " ");
	        
	    }
	    
	    while(p1 < n) sb.append(arr1[p1++] + " ");
	    while(p2 < m) sb.append(arr2[p2++] + " ");
	    
	    
	    System.out.print(sb);
	    
    }
    
}
```
