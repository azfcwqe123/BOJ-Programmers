# [Silver IV] 듣보잡 - 1764 

[문제 링크](https://www.acmicpc.net/problem/1764) 

### 성능 요약

메모리: 28988 KB, 시간: 324 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 정렬, 문자열

### 제출 일자

2024년 12월 19일 13:25:43

### 문제 설명

<p>김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.</p>

<p>듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.</p>

### 출력 

 <p>듣보잡의 수와 그 명단을 사전순으로 출력한다.</p>

---

해시맵 + 배열리스트 정렬

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while(n-- > 0) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        while(m-- > 0) {
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String x : map.keySet()) {
            if(map.get(x) == 2) {
                list.add(x);
            }
        }
        
        Collections.sort(list);
        
        for(String x : list) {
            sb.append(x).append('\n');    
        }
        
        System.out.println(list.size());
        System.out.print(sb);
        
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/dee6477a-3cf3-487f-8455-78d8a3d361c6)
