# [Silver II] A → B - 16953 

[문제 링크](https://www.acmicpc.net/problem/16953) 

### 성능 요약

메모리: 14188 KB, 시간: 100 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색, 그리디 알고리즘

### 제출 일자

2025년 1월 19일 19:55:10

### 문제 설명

<p>정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.</p>

<ul>
	<li>2를 곱한다.</li>
	<li>1을 수의 가장 오른쪽에 추가한다. </li>
</ul>

<p>A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.</p>

### 입력 

 <p>첫째 줄에 A, B (1 ≤ A < B ≤ 10<sup>9</sup>)가 주어진다.</p>

### 출력 

 <p>A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.</p>

---

BFS, 240ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static long A, B;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        long k = BFS(A);
        
        System.out.print(k == -1 ? -1 : k);
    }
    
    public static int BFS(long A) {
        Queue<Long> Q = new LinkedList<>();
        Q.offer(A);
        
        int ans = 0;
        
        while(!Q.isEmpty()) {
            long len = Q.size();
            
            for(int i=0; i<len; i++) {
                long cur = Q.poll();
                
                if(cur == B) return ans + 1;
                
                long a = cur * 2;
                long b = Long.parseLong(String.valueOf(cur) + "1");
                
                if(a <= B) {
                    Q.offer(a);
                }
                
                if(b <= B) {
                    Q.offer(b);
                }
            }
            ans++;
        }
        return -1;
    }
    
}


```

---

그리디 알고리즘, 100ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int cnt = 0;
        
        while(A < B) {
            if(B % 2 == 0) {
                B /= 2;
                cnt++;
            }
            
            else if(B % 10 == 1) {
                B /= 10;
                cnt++;
            }
            
            else break;
        }
        
        if(A == B) System.out.print(cnt + 1);
        else System.out.print(-1);
        
    }
    
}
```
그리디하게

---

 런타임 에러가 계속 났던 이유는, long으로 써야하는데 int으로 썼기때문
![image](https://github.com/user-attachments/assets/374b4057-cc00-4c08-b78b-9ed7680a3f0f)

