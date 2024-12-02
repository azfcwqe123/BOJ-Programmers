# [Silver I] 회전 초밥 - 2531 

[문제 링크](https://www.acmicpc.net/problem/2531) 

### 성능 요약

메모리: 24504 KB, 시간: 320 ms

### 분류

브루트포스 알고리즘, 슬라이딩 윈도우, 두 포인터

### 제출 일자

2024년 12월 2일 18:43:19

### 문제 설명

<p>회전 초밥 음식점에는 회전하는 벨트 위에 여러 가지 종류의 초밥이 접시에 담겨 놓여 있고, 손님은 이 중에서 자기가 좋아하는 초밥을 골라서 먹는다. 초밥의 종류를 번호로 표현할 때, 다음 그림은 회전 초밥 음식점의 벨트 상태의 예를 보여주고 있다. 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다. </p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/f29f0bd9-6114-4543-aa72-797208dc9cdd/-/preview/" style="width: 300px; height: 169px;"></p>

<p>새로 문을 연 회전 초밥 음식점이 불경기로 영업이 어려워서, 다음과 같이 두 가지 행사를 통해서 매상을 올리고자 한다.</p>

<ol>
	<li>원래 회전 초밥은 손님이 마음대로 초밥을  고르고, 먹은 초밥만큼 식대를 계산하지만, 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다. </li>
	<li>각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공한다. 만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공한다.  </li>
</ol>

<p>위 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 한다. 위 그림의 예를 가지고 생각해보자. k=4이고, 30번 초밥을 쿠폰으로 받았다고 가정하자. 쿠폰을 고려하지 않으면 4가지 다른 초밥을 먹을 수 있는 경우는 (9, 7, 30, 2), (30, 2, 7, 9), (2, 7, 9, 25) 세 가지 경우가 있는데, 30번 초밥을 추가로 쿠폰으로 먹을 수 있으므로 (2, 7, 9, 25)를 고르면 5가지 종류의 초밥을 먹을 수 있다. </p>

<p>회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수, 연속해서 먹는 접시의 개수, 쿠폰 번호가 주어졌을 때, 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 프로그램을 작성하시오. </p>

### 입력 

 <p>첫 번째 줄에는 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c가 각각 하나의 빈 칸을 사이에 두고 주어진다. 단, 2 ≤ N ≤ 30,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d이다. 두 번째 줄부터 N개의 줄에는 벨트의 한 위치부터 시작하여 회전 방향을 따라갈 때 초밥의 종류를 나타내는 1 이상 d 이하의 정수가 각 줄마다 하나씩 주어진다. </p>

### 출력 

 <p>주어진 회전 초밥 벨트에서 먹을 수 있는 초밥의 가짓수의 최댓값을 하나의 정수로 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
	    int d = Integer.parseInt(st.nextToken()); // 초밥 종류 개수
	    int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수 
	    int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
	    
	    //회전 초밥은 원형이라는걸 인지해야한다. n이 6, k=3이라고 가정할 때, 
	    // 1 2 3 -> 2 3 4 -> 3 4 5 -> 4 5 6 -> 5 6 1 -> 6 1 2 꼴로 돌아야하는데, 
	    // 즉 접시 끝에 처음부터 나왔던 초밥 k-1개만 놓으면 원형으로 모든 경우의 수를 탐색하게끔 만들 수 있다.
	    
	    // 1 2 3 4 5 6 1 2 이런식으로 말이다.
	    
	    int[] arr = new int[n + k - 1]; 
	    
	    for(int i=0; i<n; i++) {
	        arr[i] = Integer.parseInt(br.readLine());
	    }
	    
	    for(int i=n; i<n+k-1; i++) {
	        arr[i] = arr[i-n];
	    }
	    
	    boolean[] fish = new boolean[d+1]; // 초밥 종류 개수
        
        int lt=0, rt = k-1; // 연속해서 먹는 접시의 수 길이만큼 lt와 rt길이를 지정한다.
        
        int ans = 0;
        
        fish[c] = true; // 쿠폰 초밥은 항상 포함시킨다.
        
        
        while(rt < n+k-1) { // 배열의 끝까지
            
            int cnt = 0;
            
            for(int i = lt; i <= rt; i++) fish[arr[i]] = true; // 접시에 나온 초밥의 종류가 나왔다면 true
           
            for(int i = 1; i <= d; i++) { // 모든 초밥의 종류 탐색
                if(fish[i]) { // 초밥이 나왔다면
                    cnt++; // 초밥 가짓수 증가
                    if(i != c) fish[i] = false; // 쿠폰 초밥은 제외
                }
            }
            
            ans = Math.max(ans, cnt); // 최대로 큰 초밥 가짓수 반환
            
            lt++;
            rt++;
            
        }
        
        System.out.print(ans);
	    
    }
    
}

// 원형이 나오면 배열을 복사해서 붙여넣는것도 생각해보자.
```
