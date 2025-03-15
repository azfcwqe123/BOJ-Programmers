# [Gold V] 암호코드 - 2011 

[문제 링크](https://www.acmicpc.net/problem/2011) 

### 성능 요약

메모리: 16072 KB, 시간: 124 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 3월 15일 14:59:25

### 문제 설명

<p>상근이와 선영이가 다른 사람들이 남매간의 대화를 듣는 것을 방지하기 위해서 대화를 서로 암호화 하기로 했다. 그래서 다음과 같은 대화를 했다.</p>

<ul>
	<li>상근: 그냥 간단히 암호화 하자. A를 1이라고 하고, B는 2로, 그리고 Z는 26으로 하는거야.</li>
	<li>선영: 그럼 안돼. 만약, "BEAN"을 암호화하면 25114가 나오는데, 이걸 다시 글자로 바꾸는 방법은 여러 가지가 있어.</li>
	<li>상근: 그렇네. 25114를 다시 영어로 바꾸면, "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN" 총 6가지가 나오는데, BEAN이 맞는 단어라는건 쉽게 알수 있잖아?</li>
	<li>선영: 예가 적절하지 않았네 ㅠㅠ 만약 내가 500자리 글자를 암호화 했다고 해봐. 그 때는 나올 수 있는 해석이 정말 많은데, 그걸 언제 다해봐?</li>
	<li>상근: 얼마나 많은데?</li>
	<li>선영: 구해보자!</li>
</ul>

<p>어떤 암호가 주어졌을 때, 그 암호의 해석이 몇 가지가 나올 수 있는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 5000자리 이하의 암호가 주어진다. 암호는 숫자로 이루어져 있다.</p>

### 출력 

 <p>나올 수 있는 해석의 가짓수를 구하시오. 정답이 매우 클 수 있으므로, 1000000으로 나눈 나머지를 출력한다.</p>

<p>암호가 잘못되어 암호를 해석할 수 없는 경우에는 0을 출력한다.</p>

---

DP

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int mod = 1000000;
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        int len = str.length();
        
        if(str.charAt(0) == '0') {
            System.out.print(0);
            System.exit(0);
        }
        
        int[] dp = new int[len + 1];
        
        dp[0] = 1; // dp[i-2]을 계산하기 위한것. 0으로 시작하는 암호는 애초에 에러긴함
        dp[1] = 1;
        
        for(int i=2; i<=len; i++) {
            int check = Integer.parseInt(str.substring(i-2, i));
            
            if(str.charAt(i-1) != '0') dp[i] += dp[i-1] % mod;
            if(check >= 10 && check <= 26) dp[i] += dp[i-2] % mod;
        }
        
        System.out.print(dp[len] % mod);
        
    }
    
}


```

---

![2zFyZdmW0KzgGxreKZFS26-1_250315_151103](https://github.com/user-attachments/assets/6cca21e9-d8fa-42d2-880b-df6dbc1b4628)



![image](https://github.com/user-attachments/assets/819fa49a-8b50-49d7-a0e0-340a50c81049)



