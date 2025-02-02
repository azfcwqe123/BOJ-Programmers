# [Silver III] 게으른 백곰 - 10025 

[문제 링크](https://www.acmicpc.net/problem/10025) 

### 성능 요약

메모리: 41416 KB, 시간: 328 ms

### 분류

누적 합, 슬라이딩 윈도우, 두 포인터

### 제출 일자

2024년 12월 3일 22:44:45

### 문제 설명

<p>더운 여름날 동물원의 백곰 앨버트는 너무 더워서 꼼짝도 하기 싫다. 다행히도 사육사들이 앨버트의 더위를 식히기 위해 얼음이 담긴 양동이들을 가져다 주었다. 앨버트가 가장 적은 거리만 움직이고도 최대한 많은 얼음으로 더위를 식힐 수 있도록 도와주자.</p>

<p>우리 안은 1차원 배열로 생각하며, 총 N(1 ≤ N ≤ 100000)개의 얼음 양동이들이 x<sub>i</sub>(0 ≤ x<sub>i</sub> ≤ 1,000,000)좌표마다 놓여 있고 각 양동이 안에는 g<sub>i</sub>(1 ≤ g<sub>i</sub> ≤ 10,000)씩의 얼음이 들어 있다. 일단 앨버트가 자리를 잡으면 그로부터 좌우로 K(1 ≤ K ≤ 2,000,000) 만큼 떨어진 양동이까지 닿을 수 있다. 앨버트는 양동이가 놓여 있는 자리에도 자리잡을 수 있다. 모든 얼음 양동이의 위치는 다르다.</p>

<p>앨버트가 최적의 자리를 골랐을 때 얼음의 합을 구하시오. 즉, 얼음들의 합의 최댓값을 구해야 한다.</p>

### 입력 

 <p>첫 줄에 정수 N과 K가 들어온다. 둘째 줄부터 N째 줄까지, 공백을 사이에 두고 각 양동이의 얼음의 양을 나타내는 g<sub>i</sub>와 양동이의 좌표를 나타내는 x<sub>i</sub>가 주어진다.</p>

### 출력 

 <p>앨버트가 택한 최적 위치로부터 K만큼 떨어진 거리 내에 있는 얼음들의 합(최댓값)을 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int[] pos = new int[1_000_001];
	    
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
 	    
 	    while(n-- > 0) {
 	        st = new StringTokenizer(br.readLine());
 	        
 	        int g = Integer.parseInt(st.nextToken());
 	        int x = Integer.parseInt(st.nextToken());
 	        
 	        pos[x] = g;
 	    }
 	    
 	    int sum = 0, max = -1;
 	    
 	    int d = 2*k + 1;
 	    
 	    for(int i=0; i<=1_000_000; i++) {
 	        sum += pos[i];
 	        
 	        if(i >= d) sum -= pos[i-d];
 	        
 	        max = Math.max(sum, max);
 	    }
 	    
 	    System.out.print(max);
    }

}
```

문제를 잘 읽자.. 곰이 이동할수 있는 거리가 4이고, 

곰이 x=1 위치에 있을때는 x=0, x=1, x=2, x=3, x=4, x=5 즉, 6칸을 움직일 수 있다.

곰이 x=2 위치에 있을때는 x=0, x=1, x=2, x=3, x=4, x=5, x= 즉, 7칸을 움직일 수 있다.

곰이 x=4 위치에 있을때는 x=0, x=1, x=2, x=3, x=4, x=5, x=6, x=7, x=8  즉 9칸에 움직일 수 있다. 

이런 예외케이스도 생각을 하자.
