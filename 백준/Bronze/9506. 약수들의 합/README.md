# [Bronze I] 약수들의 합 - 9506 

[문제 링크](https://www.acmicpc.net/problem/9506) 

### 성능 요약

메모리: 15176 KB, 시간: 124 ms

### 분류

구현, 수학, 정수론

### 제출 일자

2024년 10월 21일 14:45:16

### 문제 설명

<p>어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, <span style="line-height:1.6em">그 수를 완전수라고 한다. </span></p>

<p>예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.</p>

<p>n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.</p>

### 입력 

 <p>입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)</p>

<p>입력의 마지막엔 -1이 주어진다.</p>

### 출력 

 <p>테스트케이스 마다 한줄에 하나씩 출력해야 한다.</p>

<p>n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).</p>

<p>이때, 약수들은 오름차순으로 나열해야 한다.</p>

<p>n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.</p>

---


첫번째 풀이
```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    while(true) {
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        if(n == -1) { // -1이 입력되면 종료
	            break;
	        }
	        
	        int sum = 0; // 완전수인지 확인하기 위한 변수
	        int cnt = 0; // '+' 문자를 넣는 범위를 판단하기 위한 변수
	        
	        StringBuilder sb = new StringBuilder();

	        for(int i=1; i<n; i++) { // 완전수인지 확인하는 반복문
	            if(n % i == 0) {
	                sum += i;    
	                cnt++;
	            }
	        }
	        
	        
	        if(sum == n) { // 완전수라면
	            
	            sb.append(n + " = ");
	            for(int i=1; i<n; i++) {
	                
	                if(n % i == 0 && cnt > 1) {
	                    sb.append(i + " + ");
	                    cnt--;
	                } else if(n % i == 0 && cnt == 1) { // 마지막 약수는 '+'을 넣지 않는다.
	                    sb.append(i);
	                }
	                
	            }
	        } else { // 완전수가 아니라면
	            sb.append(n + " is NOT perfect.");
	        }
            
            System.out.println(sb);
	        
	    }
 	    
	}
	    
}
	
```
---

두번째 풀이, 첫번째 풀이 리팩토링
```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    while(true) {
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        if(n == -1) break;
	        
	        int sum = 0;
	        
	        for(int i=1; i<n; i++) {
	            if(n % i == 0) sum += i;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        if(sum == n) {
	            sb.append(n + " = 1 "); // 1은 모든 수의 약수이니, 미리 포함 시키면 cnt을 사용할 필요 없게 됨. !! 
	            
	            for(int i=2; i<n; i++) {
	                if(n % i == 0) sb.append("+ " + i + " ");
	            }
	            
	        } else sb.append(n + " is NOT perfect.");
	        
	        
	        System.out.println(sb);
	
	        
	    }
 	    
	}
	    
}	

```

---

세번째 풀이, ArrayList 사용

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    while(true) {
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        if(n == -1) break;
	        
	        int sum = 0;
	        
	        List<Integer> list = new ArrayList<>();
	        
	        for(int i=1; i<n; i++) {
	            if(n % i == 0) {
	                sum += i;
	                list.add(i);
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        if(sum == n) {
	            sb.append(n + " = 1");
	            for(int i=1; i<list.size(); i++) {
	               sb.append(" + " + list.get(i));         
	            }
	            
	        } else {
	            sb.append(n + " is NOT perfect.");
	        }
	        
	        System.out.println(sb);
	
	        
	    }
 	    
	}
	    
}
	



```
