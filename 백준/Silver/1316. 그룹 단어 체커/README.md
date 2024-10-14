# [Silver V] 그룹 단어 체커 - 1316 

[문제 링크](https://www.acmicpc.net/problem/1316) 

### 성능 요약

메모리: 14168 KB, 시간: 100 ms

### 분류

구현, 문자열

### 제출 일자

2024년 10월 14일 15:10:57

### 문제 설명

<p>그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.</p>

<p>단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.</p>

### 출력 

 <p>첫째 줄에 그룹 단어의 개수를 출력한다.</p>

---

첫번째 풀이
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int cnt = n;
	    
	    for(int i=0; i<n; i++) {
	        String str = br.readLine();
	        int prev = 0;
	        boolean[] arr = new boolean[26];
	        
	        for(int j=0; j<str.length(); j++) {
	            
	            int now = str.charAt(j);
	            
	            if (now != prev){ 
	                if(arr[now-97] == false) {
	                    arr[now-97] = true;
	                    prev = now;
	                }
	                else {
	                    cnt--;
	                    break;
	                }
	            }
	            
	            else continue;
	            
	        }
	        
	    }
	    
	    System.out.print(cnt);
	    
	}
	
}   



```

---

두번째 풀이, 캡슐화 [Silver V] 그룹 단어 체커 - 1316 

[문제 링크](https://www.acmicpc.net/problem/1316) 

### 성능 요약

메모리: 14168 KB, 시간: 100 ms

### 분류

구현, 문자열

### 제출 일자

2024년 10월 14일 15:10:57

### 문제 설명

<p>그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.</p>

<p>단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.</p>

### 출력 

 <p>첫째 줄에 그룹 단어의 개수를 출력한다.</p>

---

첫번째 풀이
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int cnt = n;
	    
	    for(int i=0; i<n; i++) {
	        String str = br.readLine();
	        int prev = 0;
	        boolean[] arr = new boolean[26];
	        
	        for(int j=0; j<str.length(); j++) {
	            
	            int now = str.charAt(j);
	            
	            if (now != prev){ 
	                if(arr[now-97] == false) {
	                    arr[now-97] = true;
	                    prev = now;
	                }
	                else {
	                    cnt--;
	                    break;
	                }
	            }
	            
	            else continue;
	            
	        }
	        
	    }
	    
	    System.out.print(cnt);
	    
	}
	
}   



```

---

두번째 풀이, 리팩터링
```java
import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    
	    for(int i=0; i<n; i++) {
            check(br.readLine());     
	    }
	        
	    System.out.print(cnt);
	    
	}
	
	static void check(String str) {
	    
	    int prev = 0;
	    boolean[] arr = new boolean[26];
	    
	    for(int i=0; i<str.length(); i++) {
	        
	        int now = str.charAt(i); // 앞에서부터 문자 하나하나 비교할 것임
	        
	        if(prev != now) { // 이전 문자와 같지 않다면 체크
	            if(arr[now-97] == false) { // 현재 문자가 나온 적이 없다면
	                arr[now-97] = true; // true로 체크
	                prev = now; // 그다음 순회를 위해 이전문자에 현재 문자를 넣어준다.
	            } else return; // 현재 문자가 나온적이 있다면 함수 탈출
	        }
	        
	        else continue; // 이전 문자와 같다면 패스, prev는 사실상 이때 쓰인다.
	        
	    }
	    
	    cnt++; // 반복문을 다 돌았다면 cnt++
	    
	}
	
}   



```
