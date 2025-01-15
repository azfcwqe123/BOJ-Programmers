# [Silver III] 선분 위의 점 - 11663 

[문제 링크](https://www.acmicpc.net/problem/11663) 

### 성능 요약

메모리: 58420 KB, 시간: 896 ms

### 분류

이분 탐색, 정렬

### 제출 일자

2025년 1월 15일 16:23:12

### 문제 설명

<p>일차원 좌표상의 점 N개와 선분 M개가 주어진다. 이때, 각각의 선분 위에 입력으로 주어진 점이 몇 개 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 점의 개수 N과 선분의 개수 M이 주어진다. (1 ≤ N, M ≤ 100,000) 둘째 줄에는 점의 좌표가 주어진다. 두 점이 같은 좌표를 가지는 경우는 없다. 셋째 줄부터 M개의 줄에는 선분의 시작점과 끝점이 주어진다. 입력으로 주어지는 모든 좌표는 1,000,000,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>입력으로 주어진 각각의 선분 마다, 선분 위에 입력으로 주어진 점이 몇 개 있는지 출력한다.</p>

---

이분 탐색

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int lower = Integer.parseInt(st.nextToken());
            int upper = Integer.parseInt(st.nextToken());
            
            sb.append(upperBound(upper) - lowerBound(lower) + 1);
            sb.append("\n");
        }
        
        System.out.print(sb);
        
    }
    
    // 자신보다 크거나 같은
    public static int lowerBound(int lower) {
        
        int lt = 0;
        int rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(arr[mid] < lower) lt = mid + 1;
            else rt = mid - 1;
        }
        
        return lt;
    }
    
    // 자신보다 작거나 같은
    public static int upperBound(int upper) {
        
        int lt = 0;
        int rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(upper < arr[mid]) rt = mid - 1;
            else lt = mid + 1;
        }
        
        return rt;
    }
}


```

---

![image](https://github.com/user-attachments/assets/89d3e293-2258-4f93-a961-e6df00dde81f)

![image](https://github.com/user-attachments/assets/1669e074-427f-4fa8-a6b2-34ac36daa106)

다시 풀어볼것
