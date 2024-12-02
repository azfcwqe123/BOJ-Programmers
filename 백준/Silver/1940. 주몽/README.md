# [Silver IV] 주몽 - 1940 

[문제 링크](https://www.acmicpc.net/problem/1940) 

### 성능 요약

메모리: 16408 KB, 시간: 172 ms

### 분류

정렬, 두 포인터

### 제출 일자

2024년 12월 2일 17:33:13

### 문제 설명

<p>주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다. 야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.</p>

<p>갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다. 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다. 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다. 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다. 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 갑옷을 만들 수 있는 개수를 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int m = Integer.parseInt(br.readLine());
	    
	    int[] arr = new int[n];
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    
	    int lt=0, rt = arr.length - 1; // lt를 맨 왼쪽에, rt를 맨 오른쪽에
	    
	    int ans = 0;

          // 배열에 있는 숫자들이 고유하다는 점 또한 고려한다.
	    while(lt < rt) { 
	        
	        if(arr[lt] + arr[rt] == m) {
	            ans++;
	            lt++; 
	            rt--;
	        }
	        
	        else if(arr[lt] + arr[rt] < m) lt++; // m보다 작으면, 왼쪽에 있는 숫자(작은 숫자) 오른쪽(큰 숫자)으로 옮긴다.
	        
	        else if(arr[lt] + arr[rt] > m) rt--; // m보다 크면, 오른쪽에 있는 숫자(큰 숫자)를 왼쪽(작은 숫자)으로 옮긴다.
	            
	        } 
	    
	    
	    System.out.print(ans);

	    
    }
    
}
```
