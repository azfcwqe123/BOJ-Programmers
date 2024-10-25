# [Bronze III] 삼각형과 세 변 - 5073 

[문제 링크](https://www.acmicpc.net/problem/5073) 

### 성능 요약

메모리: 14268 KB, 시간: 100 ms

### 분류

기하학, 구현, 수학

### 제출 일자

2024년 10월 25일 14:24:40

### 문제 설명

<p>삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.</p>

<ul>
	<li>Equilateral :  세 변의 길이가 모두 같은 경우</li>
	<li>Isosceles : 두 변의 길이만 같은 경우</li>
	<li>Scalene : 세 변의 길이가 모두 다른 경우</li>
</ul>

<p>단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.</p>

<p>세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.</p>

### 입력 

 <p>각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.</p>

### 출력 

 <p>각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.</p>

---

첫번째 풀이, Arrays.sort() 사용, 104ms

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    while(true) {
	        
	        int[] arr = new int[3];
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        arr[0] = Integer.parseInt(st.nextToken());
	        arr[1] = Integer.parseInt(st.nextToken());
	        arr[2] = Integer.parseInt(st.nextToken());
	        
	        if(arr[0]==0 && arr[1]==0 && arr[2]==0) return;
	        
	        Arrays.sort(arr);
	        
	        if(arr[0] + arr[1] > arr[2]) {
	            
	            if(arr[0]==arr[1] && arr[1]==arr[2]) System.out.println("Equilateral");
	            else if(arr[0]==arr[1] || arr[1]==arr[2] || arr[0]==arr[2]) System.out.println("Isosceles");
	            else System.out.println("Scalene");    
	            
	        } else {
	            System.out.println("Invalid");
	        }
	        
       
	    }
	    
	    
	}
}




```

---

두번째 풀이, 100ms

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    while(true) {
	        	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        
	        if(a==0 && b==0 && c==0) return;
	        
	        if(a + b > c && a + c > b && b + c > a) { // 삼각형의 조건은 두 변의 길이가 가장 큰 한 변의 길이보다 커야한다.
	            if(a==b && b==c) System.out.println("Equilateral");
	            else if(a==b || b==c || c==a) System.out.println("Isosceles");
	            else System.out.println("Scalene");    
	        } else {
	            System.out.println("Invalid");
	        }	        
	    }	    
	    
	}
}




```

