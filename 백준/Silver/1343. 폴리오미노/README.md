# [Silver V] 폴리오미노 - 1343 

[문제 링크](https://www.acmicpc.net/problem/1343) 

### 성능 요약

메모리: 14180 KB, 시간: 100 ms

### 분류

그리디 알고리즘, 구현

### 제출 일자

2024년 12월 23일 11:37:25

### 문제 설명

<p>민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB</p>

<p>이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.</p>

<p>폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.</p>

### 출력 

 <p>첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.</p>

---
그리디 알고리즘 문제
&nbsp;

정규표현식 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        str = str.replaceAll("(" + "XXXX" + ")", "AAAA").replaceAll("(" + "XX" + ")", "BB");;
        
        if(str.contains("X")) System.out.print(-1);
        else System.out.print(str);
    }
    
}


```

---

직접 구현

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int x = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++) {
            
            if(str.charAt(i) == '.') { // XXX. 같은 경우가 나와버리면 x=0으로 초기화 시켜버림. BB가 나올수 없게됨
                sb.append(".");
                x = 0;
            }
            
            if(str.charAt(i) == 'X') {
                x++;
                    
                if(x == 2) { // x = 2일 경우, XX. 이거나 ~~XX일때만 BB로 바뀐다. 나머지는 패스.
                    if(i+1 < str.length() && str.charAt(i+1) == '.') {
                        sb.append("BB");
                        x = 0;
                    }
                    
                    else if(i == str.length() - 1) {
                        sb.append("BB");
                        x = 0;
                    }
                    
                }    
                    
                if(x == 4) {
                    sb.append("AAAA");
                    x = 0;
                }
                
            }
            
        }
        
        String ans = sb.toString();
        
        if(ans.length() != str.length()) System.out.print(-1);
        else System.out.print(ans);
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/fdfc2b90-93e6-4d48-b7bd-378d8594a8e1)
