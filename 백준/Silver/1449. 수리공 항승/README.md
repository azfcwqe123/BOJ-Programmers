# [Silver III] 수리공 항승 - 1449 

[문제 링크](https://www.acmicpc.net/problem/1449) 

### 성능 요약

메모리: 14232 KB, 시간: 116 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2025년 1월 23일 14:47:43

### 문제 설명

<p>항승이는 품질이 심각하게 나쁜 수도 파이프 회사의 수리공이다. 항승이는 세준 지하철 공사에서 물이 샌다는 소식을 듣고 수리를 하러 갔다.</p>

<p>파이프에서 물이 새는 곳은 신기하게도 가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샌다.</p>

<p>항승이는 길이가 L인 테이프를 무한개 가지고 있다.</p>

<p>항승이는 테이프를 이용해서 물을 막으려고 한다. 항승이는 항상 물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다.</p>

<p>물이 새는 곳의 위치와, 항승이가 가지고 있는 테이프의 길이 L이 주어졌을 때, 항승이가 필요한 테이프의 최소 개수를 구하는 프로그램을 작성하시오. 테이프를 자를 수 없고, 테이프를 겹쳐서 붙이는 것도 가능하다.</p>

### 입력 

 <p>첫째 줄에 물이 새는 곳의 개수 N과 테이프의 길이 L이 주어진다. 둘째 줄에는 물이 새는 곳의 위치가 주어진다. N과 L은 1,000보다 작거나 같은 자연수이고, 물이 새는 곳의 위치는 1,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 항승이가 필요한 테이프의 개수를 출력한다.</p>

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
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
         
        Arrays.sort(arr); // 정렬 필수
        
        int ans = 1, pos = arr[0]; // 처음 위치를 잡고, 테이프 하나를 추가해준다.
        
        for(int i=1; i<N; i++) {
            
            if(arr[i] - pos < L) continue; // 탐색한다. 탐색 위치 - 현재 위치 < 테이프 길이가 나오면 탐색 위치를 테이프로 덮을 수 있다.
            
            else { // 덮으려는 길이가 테이프의 길이를 초과해버린 상태.
                pos = arr[i]; // 현재 위치 재설정
                ans++; // 테이프 추가
            }
            
        }
        
        System.out.print(ans);
    }
    
}

```

![image](https://github.com/user-attachments/assets/30a524a2-784d-4c6e-a6f0-4b98e2c504b9)

규칙만 잘 찾으면 수월하게 풀 수 있는 문제인듯하다

---

![image](https://github.com/user-attachments/assets/e342372e-8cd4-46b9-a602-41ac3bdee265)
