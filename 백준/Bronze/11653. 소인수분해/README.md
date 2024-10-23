# [Bronze I] 소인수분해 - 11653 

[문제 링크](https://www.acmicpc.net/problem/11653) 

### 성능 요약

메모리: 14304 KB, 시간: 108 ms

### 분류

수학, 정수론, 소수 판정

### 제출 일자

2024년 10월 23일 14:46:59

### 문제 설명

<p>정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.</p>

### 출력 

 <p>N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.</p>

---

첫번째 풀이, 시간 초과 
```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=2; i<=n; i++) {
	        
	        if(isPrime(i)) { // 소수가 맞다면
	           
	           while(true) { // n이 소수로 안 나눠질때까지 나눈다.
	               
	               if(n % i != 0) break; // 더이상 안나눠지면 다음 소수로
	               
	               n /= i;
	               
	               sb.append(i).append('\n');
	               
	           }     
	        }
	    }
	    
	    System.out.print(sb);
	    
	}
	
	
	static boolean isPrime(int k) { // 소수인지 판별
	    
	        for(int i=2; i<k; i++) {
	            if(k % i == 0) return false;
	        }    
	    
	    return true;
	}
	     
}




```

---

두번째 풀이, 136ms

```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=2; i<=n; i++) {
	 
	        while(n % i == 0) {
	            sb.append(i).append("\n");
	            
	            n /= i;
	        }       
	       
	    }
	    
	    
	    
	    System.out.print(sb);
	    
	}
}

```

---

세번째 풀이, 108ms, 에라토스테네스의 체 원리 사용
```java
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=2; i*i<=n; i++) { // 에라토스테네스의 체 원리 사용, 소수의 제곱이 n보다 작으면, n 안에 있는 해당 소수는 모두 처리된다.
	 
	        while(n % i == 0) { // 1이 될때까지 계속 나눈다.
	            sb.append(i).append("\n");
	            
	            n /= i;
	        }       
	       
	    }
	    
	    if(n != 1) { // 1이 아니라면 마지막 소인수의 처리를 해준다.
	        sb.append(n);
	    }
   
	    System.out.print(sb);
	    
	}
}


```

---

