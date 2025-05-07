# [Silver IV] 비밀번호 찾기 - 17219 

[문제 링크](https://www.acmicpc.net/problem/17219) 

### 성능 요약

메모리: 58036 KB, 시간: 588 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 집합과 맵

### 제출 일자

2025년 5월 7일 16:09:00

### 문제 설명

<p>2019 HEPC - MAVEN League의 "<a href="/problem/17218">비밀번호 만들기</a>"와 같은 방식으로 비밀번호를 만든 경민이는 한 가지 문제점을 발견하였다. 비밀번호가 랜덤으로 만들어져서 기억을 못 한다는 것이었다! 그래서 경민이는 메모장에 사이트의 주소와 비밀번호를 저장해두기로 했다. 하지만 컴맹인 경민이는 메모장에서 찾기 기능을 활용하지 못하고 직접 눈으로 사이트의 주소와 비밀번호를 찾았다. 메모장에 저장된 사이트의 수가 늘어나면서 경민이는 비밀번호를 찾는 일에 시간을 너무 많이 쓰게 되었다. 이를 딱하게 여긴 문석이는 경민이를 위해 메모장에서 비밀번호를 찾는 프로그램을 만들기로 결심하였다! 문석이를 도와 경민이의 메모장에서 비밀번호를 찾아주는 프로그램을 만들어보자.</p>

### 입력 

 <p>첫째 줄에 저장된 사이트 주소의 수 N(1 ≤ N ≤ 100,000)과 비밀번호를 찾으려는 사이트 주소의 수 M(1 ≤ M ≤ 100,000)이 주어진다.</p>

<p>두번째 줄부터 N개의 줄에 걸쳐 각 줄에 사이트 주소와 비밀번호가 공백으로 구분되어 주어진다. 사이트 주소는 알파벳 소문자, 알파벳 대문자, 대시('-'), 마침표('.')로 이루어져 있고, 중복되지 않는다. 비밀번호는 알파벳 대문자로만 이루어져 있다. 모두 길이는 최대 20자이다.</p>

<p>N+2번째 줄부터 M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소가 한줄에 하나씩 입력된다. 이때, 반드시 이미 저장된 사이트 주소가 입력된다.</p>

### 출력 

 <p>첫 번째 줄부터 M개의 줄에 걸쳐 비밀번호를 찾으려는 사이트 주소의 비밀번호를 차례대로 각 줄에 하나씩 출력한다.</p>

---

해시맵 기초

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        HashMap<String, String> map = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            String site = st.nextToken(); // 사이트 이름
            String password = st.nextToken(); // 비밀번호
            
            map.put(site, password); // 해시맵에 저장
        }
        
        for(int i=0; i<m; i++) {
            String tmp = br.readLine();
            
            sb.append(map.get(tmp)).append('\n'); // key에 해당하는 value 출력
        }
        
        System.out.print(sb);
        
    }
    
}


```

![image](https://github.com/user-attachments/assets/409d2e84-cde3-4b94-9d41-385b38ad5264)
