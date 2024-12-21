# [Silver V] 단어 정렬 - 1181 

[문제 링크](https://www.acmicpc.net/problem/1181) 

### 성능 요약

메모리: 23884 KB, 시간: 460 ms

### 분류

정렬, 문자열

### 제출 일자

2024년 12월 21일 15:57:27

### 문제 설명

<p>알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.</p>

<ol>
	<li>길이가 짧은 것부터</li>
	<li>길이가 같으면 사전 순으로</li>
</ol>

<p>단, 중복된 단어는 하나만 남기고 제거해야 한다.</p>

### 입력 

 <p>첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.</p>

### 출력 

 <p>조건에 따라 정렬하여 단어들을 출력한다.</p>

---

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        HashSet<String> set = new HashSet<>();
        
        while(n-- > 0) set.add(br.readLine());
        
        ArrayList<String> list = new ArrayList<>(set); // 배열리스트 생성과 동시에 해시셋 요소 넣기
        
        Collections.sort(list, (a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });
        
        for(String x : list) System.out.println(x);
        
    }
}


```

첫번째 틀린 이유는 중복 제거를 안 했음. 문제를 똑바로 읽지 않았다.

![image](https://github.com/user-attachments/assets/f762f090-d8f0-4461-a18d-529e061705f0)
