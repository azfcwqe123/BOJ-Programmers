# [Gold III] 텀 프로젝트 - 9466 

[문제 링크](https://www.acmicpc.net/problem/9466) 

### 성능 요약

메모리: 302708 KB, 시간: 1060 ms

### 분류

깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 13일 23:46:45

### 문제 설명

<p>이번 가을학기에 '문제 해결' 강의를 신청한 학생들은 텀 프로젝트를 수행해야 한다. 프로젝트 팀원 수에는 제한이 없다. 심지어 모든 학생들이 동일한 팀의 팀원인 경우와 같이 한 팀만 있을 수도 있다. 프로젝트 팀을 구성하기 위해, 모든 학생들은 프로젝트를 함께하고 싶은 학생을 선택해야 한다. (단, 단 한 명만 선택할 수 있다.) 혼자 하고 싶어하는 학생은 자기 자신을 선택하는 것도 가능하다.</p>

<p>학생들이(s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>r</sub>)이라 할 때, r=1이고 s<sub>1</sub>이 s<sub>1</sub>을 선택하는 경우나, s<sub>1</sub>이 s<sub>2</sub>를 선택하고, s<sub>2</sub>가 s<sub>3</sub>를 선택하고,..., s<sub>r-1</sub>이 s<sub>r</sub>을 선택하고, s<sub>r</sub>이 s<sub>1</sub>을 선택하는 경우에만 한 팀이 될 수 있다.</p>

<p>예를 들어, 한 반에 7명의 학생이 있다고 하자. 학생들을 1번부터 7번으로 표현할 때, 선택의 결과는 다음과 같다.</p>

<table class="table table-bordered" style="width:30%">
	<thead>
		<tr>
			<th>1</th>
			<th>2</th>
			<th>3</th>
			<th>4</th>
			<th>5</th>
			<th>6</th>
			<th>7</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>3</td>
			<td>1</td>
			<td>3</td>
			<td>7</td>
			<td>3</td>
			<td>4</td>
			<td>6</td>
		</tr>
	</tbody>
</table>

<p>위의 결과를 통해 (3)과 (4, 7, 6)이 팀을 이룰 수 있다. 1, 2, 5는 어느 팀에도 속하지 않는다.</p>

<p>주어진 선택의 결과를 보고 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하는 프로그램을 작성하라.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫 줄에는 학생의 수가 정수 n (2 ≤ n ≤ 100,000)으로 주어진다. 각 테스트 케이스의 둘째 줄에는 선택된 학생들의 번호가 주어진다. (모든 학생들은 1부터 n까지 번호가 부여된다.)</p>

### 출력 

 <p>각 테스트 케이스마다 한 줄에 출력하고, 각 줄에는 프로젝트 팀에 속하지 못한 학생들의 수를 나타내면 된다.</p>

---

그래프 + DFS

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int ans;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            visited = new boolean[k+1]; // 재방문 체크용
            finished = new boolean[k+1]; // 탐색 여부
            arr = new int[k+1];
            ans = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i=1; i<=k; i++) {
                DFS(i);
            }
            
            System.out.println(k - ans); // 전체인원 - 사이클에 포함된 인원
        }
    }
    
    static void DFS(int x) {
        
        if(finished[x]) return; // 탐색이 이미 끝났다면 리턴
        
        if(visited[x]) { // 재방문 한다면 (사이클이 있다는 뜻) 
            finished[x] = true;
            ans++;
        }    
        
        visited[x] = true; // 방문
        DFS(arr[x]);
        finished[x] = true; // 탐색 끝
        
    }
    
    
}


```
생각보다 어렵다.

문제를 풀다가 모르겠으면 스택을 그려가면서도 풀어보자.



---

![image](https://github.com/user-attachments/assets/73b68513-a0f3-434f-99c0-201b44aa3d34)

---

![image](https://github.com/user-attachments/assets/80116a0e-d973-4d75-bcbf-3baf1db79238)

