# [Silver V] 2차원 배열의 합 - 2167 

[문제 링크](https://www.acmicpc.net/problem/2167) 

### 성능 요약

메모리: 28604 KB, 시간: 380 ms

### 분류

구현, 누적 합

### 제출 일자

2024년 12월 3일 20:44:08

### 문제 설명

<p>2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.</p>

### 입력 

 <p>첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다. 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M).</p>

### 출력 

 <p>K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 2<sup>31</sup>-1보다 작거나 같다.</p>

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
	    int m = Integer.parseInt(st.nextToken());
 	    
 	    int[][] arr = new int[n+1][m+1];
 	    int[][] prefixSum = new int[n+1][m+1];
 	    
 	    for(int i=1; i<=n; i++) { // 입력과 동시에 2차원 배열 누적합을 구한다.
 	        st = new StringTokenizer(br.readLine());
 	        for(int j=1; j<=m; j++) {
 	            arr[i][j] = Integer.parseInt(st.nextToken());
 	            prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + arr[i][j];
 	        }
 	    }
 
 	    
 	    int k = Integer.parseInt(br.readLine());
 	    
 	    for(int l=0; l<k; l++) { // 머릿속으로 떠올리면서 공부하자
 	        st = new StringTokenizer(br.readLine());
 	        
 	        int i = Integer.parseInt(st.nextToken());
 	        int j = Integer.parseInt(st.nextToken());
 	        int x = Integer.parseInt(st.nextToken());
 	        int y = Integer.parseInt(st.nextToken());
 	        
 	        int ans = prefixSum[x][y] - prefixSum[i-1][y] - prefixSum[x][j-1] + prefixSum[i-1][j-1];
 	        
 	        System.out.println(ans);
 	    }
 	    
    }

}
```
