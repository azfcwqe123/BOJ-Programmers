# [Silver V] 부분 문자열 - 6550 

[문제 링크](https://www.acmicpc.net/problem/6550) 

### 성능 요약

메모리: 17144 KB, 시간: 156 ms

### 분류

그리디 알고리즘, 문자열

### 제출 일자

2025년 1월 12일 22:51:27

### 문제 설명

<p>2개의 문자열 s와 t가 주어졌을 때 s가 t의 부분 문자열인지 판단하는 프로그램을 작성하라. 부분 문자열을 가지고 있는지 판단하는 방법은 t에서 몇 개의 문자를 제거하고 이를 순서를 바꾸지 않고 합쳤을 경우 s가 되는 경우를 이야기 한다.</p>

### 입력 

 <p>입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문자열 s 와 t가 빈칸을 사이에 두고 들어온다. s와 t의 길이는 10만을 넘지 않는다.</p>

### 출력 

 <p>입력된 s와 t의 순서대로 s가 t의 부분 문자열인 경우 Yes라 출력하고 아닐 경우 No라고 출력한다.</p>

---

그리디 알고리즘, 투포인터 이용, 입력 방법

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str;
        
        StringBuilder sb = new StringBuilder();
        
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            
            String s = st.nextToken();
            String t = st.nextToken();
            
            int p1 = 0;
            
            for(int p2 = 0; p2 < t.length(); p2++) {
                if(s.charAt(p1) == t.charAt(p2)) p1++;
                if(p1 == s.length()) break; // 문자열 s을 완성했다면 break;
            }
            
            String ans = (p1 == s.length()) ? "Yes" : "No";
            sb.append(ans).append('\n');
        }
        
        System.out.print(sb);
    }
}

```

그리디 알고리즘과 투포인터가 곁들어진 문제인것 같다. 

---

![image](https://github.com/user-attachments/assets/c2603abc-4293-439a-892b-2f27335ab5e3)
