# [Silver V] 좌표 정렬하기 - 11650 

[문제 링크](https://www.acmicpc.net/problem/11650) 

### 성능 요약

메모리: 55616 KB, 시간: 760 ms

### 분류

정렬

### 제출 일자

2024년 12월 27일 16:22:29

### 문제 설명

<p>2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 x<sub>i</sub>와 y<sub>i</sub>가 주어진다. (-100,000 ≤ x<sub>i</sub>, y<sub>i</sub> ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.</p>

### 출력 

 <p>첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.</p>

---

좌표 정렬

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            pos[i][0] = x;
            pos[i][1] = y;
        }
        
        Arrays.sort(pos, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int[] x : pos) sb.append(x[0] + " " + x[1]).append('\n');
        
        System.out.print(sb);
        
    }
    
}


```

---
처음 푼 1120ms는 StringBuilder()을 사용하지 않았을때 나온 결과
![image](https://github.com/user-attachments/assets/e33515ff-3e21-4629-811b-4287b768b55e)
