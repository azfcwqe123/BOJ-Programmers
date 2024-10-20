# [Bronze I] 달팽이는 올라가고 싶다 - 2869 

[문제 링크](https://www.acmicpc.net/problem/2869) 

### 성능 요약

메모리: 14392 KB, 시간: 96 ms

### 분류

수학

### 제출 일자

2024년 10월 20일 15:36:03

### 문제 설명

<p>땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.</p>

<p>달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.</p>

<p>달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)</p>

### 출력 

 <p>첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.</p>

---

시간 초과 나온 코드. 시간 제한이 0.25초라서 반복문으로 구하면 안 됨.
```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    int V = Integer.parseInt(st.nextToken());
	    
	    int cnt = 0;
	    int sum = 0;
	    
	    while(true) {
	        sum += A;
	        
	        if(sum >= V) {
	           System.out.print(++cnt);
	           return;
	        }
	            
	        sum -= B;
	        
	        cnt++;
	    }
	    
 	    
	}
	    
}
	



```

---

수학적으로 푼 코드
```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    int V = Integer.parseInt(st.nextToken());
	    
	    int ans = (V-A)/(A-B); // 나중에 한번에 A로 올라갈 수 있는지 판단하기 위해 목적지에서 A만큼 빼준다.
	    
	    if((V-A)%(A-B) == 0) { // V-A에서 하루에 갈 수 있는 거리를 나눴을때, 0이 나오면 하루만 더 A만큼 가면되니 하루를 더해준다.
	        ans++;
	    } else ans+=2; // 나머지가 나온다면 2일을 더 가야한다. 
	    
	    System.out.print(ans);
 	    
	}
	    
}

```
