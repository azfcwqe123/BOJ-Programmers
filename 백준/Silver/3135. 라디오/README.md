# [Silver V] 라디오 - 3135 

[문제 링크](https://www.acmicpc.net/problem/3135) 

### 성능 요약

메모리: 14076 KB, 시간: 104 ms

### 분류

그리디 알고리즘, 수학

### 제출 일자

2025년 1월 12일 22:24:50

### 문제 설명

<p>준하는 라디오 수집광으로 신제품의 라디오가 나올때마다 흥분을 금치 못한다고 한다.</p>

<p>최근 준하가 구입한 라디오는 매우 하이테크 한데, 그 라디오에는 다음과 같은 버튼이 있다.</p>

<ul>
	<li>첫 번째 버튼은 주파수를 1MHz 증가시킨다.</li>
	<li>두 번째 버튼은 주파수를 1MHz 감소시킨다.</li>
	<li>나머지 N개의 버튼은 즐겨찾기 기능으로, 미리 지정된 주파수로 이동한다.</li>
</ul>

<p>준하는 몸이 안좋아 하루에 손가락을 몇 번 움직이지 못하기 때문에 우리의 도움이 필요하다.</p>

<p>현재 주파수 A와 듣고싶은 주파수 B가 주어질 때, </p>

<p>주파수 A에서 B로 갈 때 눌러야 하는 가장 적은 버튼수를 구해주자.</p>

### 입력 

 <p>첫 줄엔 정수 A와 B가 주어진다 (1 ≤ A, B < 1000, A ≠ B).</p>

<p>다음 줄엔 정수 N이 주어진다 (1 ≤ N ≤ 5).</p>

<p>다음 N개의 줄엔 미리 지정되어 있는 주파수가 주어진다 (주파수는 1000 보다 작다).</p>

### 출력 

 <p>주파수 A에서 B로 갈 때 눌러야 하는 버튼수의 최솟값을 출력한다.</p>

---

첫번째 풀이, 배열 리스트 사용했지만, 굳이 사용할 필요 없었음.

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        int ans = Math.abs(A - B);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(Math.abs(k - B));
        }
        
        Collections.sort(list);
        
        ans = Math.min(ans, list.get(0) + 1);
        
        System.out.println(ans);
    }
    
}


```

---

두번째 풀이(리팩토링), 더 깔끔한 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        int ans = Math.abs(A - B);
        
        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            ans = Math.min(ans, Math.abs(tmp - B) + 1);
        }
        
        System.out.println(ans);
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/4163eb66-4d26-46a8-9055-98c475709bc8)
