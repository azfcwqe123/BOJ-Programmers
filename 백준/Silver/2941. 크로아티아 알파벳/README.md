# [Silver V] 크로아티아 알파벳 - 2941 

[문제 링크](https://www.acmicpc.net/problem/2941) 

### 성능 요약

메모리: 14188 KB, 시간: 104 ms

### 분류

구현, 문자열

### 제출 일자

2024년 10월 13일 21:16:22

### 문제 설명

<p>예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.</p>

<table class="table table-bordered table-center-20 th-center td-center">
	<thead>
		<tr>
			<th>크로아티아 알파벳</th>
			<th>변경</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>č</td>
			<td>c=</td>
		</tr>
		<tr>
			<td>ć</td>
			<td>c-</td>
		</tr>
		<tr>
			<td>dž</td>
			<td>dz=</td>
		</tr>
		<tr>
			<td>đ</td>
			<td>d-</td>
		</tr>
		<tr>
			<td>lj</td>
			<td>lj</td>
		</tr>
		<tr>
			<td>nj</td>
			<td>nj</td>
		</tr>
		<tr>
			<td>š</td>
			<td>s=</td>
		</tr>
		<tr>
			<td>ž</td>
			<td>z=</td>
		</tr>
	</tbody>
</table>

<p>예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.</p>

<p>dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.</p>

### 입력 

 <p>첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.</p>

<p>단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.</p>

### 출력 

 <p>입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.</p>

 ---

첫번째 풀이, 조건문으로 일일이 따지면서 들어가기, 104ms
```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char[] arr = br.readLine().toCharArray();
	    
	    int cnt = 0;
	    
	    for(int i=0; i<arr.length; i++) {
	        
	        if(arr[i] == 'c') {
	            if(i+1 < arr.length && (arr[i+1] == '=' || arr[i+1] == '-')) {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else if(arr[i] == 'd') {
	            if(i+1 < arr.length && arr[i+1] == 'z') { // 배열범위를 먼저 체크해줘야 한다. 그렇지 않으면 런타임에러 발생 가능성이 있다.
	                if(i+2 < arr.length && arr[i+2] == '=') {
	                    cnt++;
	                    i+=2;
	                } else { // dz인 경우
	                    cnt++;
	                }
	            }
	            
	            else if(i+1 < arr.length && arr[i+1] == '-') {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else if(arr[i] == 'l' || arr[i] == 'n' ) {
	            if(i+1 < arr.length && arr[i+1] == 'j') {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else if(arr[i] == 's' || arr[i] == 'z') {
	            if(i+1 < arr.length && arr[i+1] == '=') {
	                cnt++;
	                i++;
	            }
	            
	            else cnt++;
	        }
	        
	        else cnt++;
	        
	    }
	    
	    System.out.print(cnt);
	    
	}
	
}   



```

---

replace() 사용, 104ms

```java
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine();
	    
	    String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	    
	    for(int i=0; i<arr.length; i++) { // 배열에 있는 요소들을 문자열과 일일이 대조시켜본다.
	        if(str.contains(arr[i])) str = str.replace(arr[i], "*");
	    }
	    
	    System.out.print(str.length());
	    
	}
	
}   



```

