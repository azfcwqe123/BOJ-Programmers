# [Silver V] 숫자 카드 - 10815 

[문제 링크](https://www.acmicpc.net/problem/10815) 

### 성능 요약

메모리: 135412 KB, 시간: 860 ms

### 분류

이분 탐색, 자료 구조, 해시를 사용한 집합과 맵, 정렬

### 제출 일자

2024년 12월 18일 00:20:18

### 문제 설명

<p>숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.</p>

<p>셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다</p>

### 출력 

 <p>첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.</p>

---

해시셋

```java
import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) set.add(Integer.parseInt(st.nextToken()));
   
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while(m-- > 0) {
            int k = Integer.parseInt(st.nextToken());
            
            if(set.contains(k)) sb.append("1 ");
            else sb.append("0 ");
        }
        
        System.out.print(sb);

    }
    
}


```

---

StringBuilder 썼을때와 안 썼을때의 차이
![image](https://github.com/user-attachments/assets/413a07e3-c9b2-42d0-81ca-e6be022e7d5e)
