# [Silver IV] 수 찾기 - 1920 

[문제 링크](https://www.acmicpc.net/problem/1920) 

### 성능 요약

메모리: 47864 KB, 시간: 644 ms

### 분류

이분 탐색, 자료 구조, 해시를 사용한 집합과 맵, 정렬

### 제출 일자

2024년 12월 24일 15:03:33

### 문제 설명

<p>N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -2<sup>31</sup> 보다 크거나 같고 2<sup>31</sup>보다 작다.</p>

### 출력 

 <p>M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.</p>

---

이분 탐색

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            
            if(binarySearch(arr, k) >= 0) sb.append(1);
            else sb.append(0);
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static int binarySearch(int[] arr, int k) {
        
        int lt = 0, rt = arr.length - 1;
        
        while(lt <= rt) {
            
            int mid = (lt + rt) / 2;
            
            if(k < arr[mid]) rt = mid - 1;
            else if(k > arr[mid]) lt = mid + 1;
            else return mid;
        }
        
        return -1;
        
    }
    
        
}


```

---

이분 탐색(Arrays 클래스의 이분탐색 메서드 이용 방법)

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            
            if(Arrays.binarySearch(arr, k) >= 0) sb.append(1);
            else sb.append(0);
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
        
}


```

메서드 사용하는건 버릇 안좋아지니 웬만하면 직접 구현도 꼭 해보자.

---
참고 블로그 : https://st-lab.tistory.com/261

![image](https://github.com/user-attachments/assets/6b57ad76-e554-4eb3-8979-45c4278f85ed)

이분탐색 메서드를 이용하나, 이분탐색 알고리즘을 직접 만들어서 사용하거나 별 큰 차이는 없다.
