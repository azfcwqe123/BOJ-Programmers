# [Silver V] 회사에 있는 사람 - 7785 

[문제 링크](https://www.acmicpc.net/problem/7785) 

### 성능 요약

메모리: 44464 KB, 시간: 512 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵

### 제출 일자

2024년 12월 18일 00:09:38

### 문제 설명

<p>상근이는 세계적인 소프트웨어 회사 기글에서 일한다. 이 회사의 가장 큰 특징은 자유로운 출퇴근 시간이다. 따라서, 직원들은 반드시 9시부터 6시까지 회사에 있지 않아도 된다.</p>

<p>각 직원은 자기가 원할 때 출근할 수 있고, 아무때나 퇴근할 수 있다.</p>

<p>상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다. 이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다. 로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 10<sup>6</sup>) 다음 n개의 줄에는 출입 기록이 순서대로 주어지며, 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다. "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.</p>

<p>회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.</p>

### 출력 

 <p>현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.</p>


---

첫번째 풀이, 해시맵 + 배열리스트 사용, 1212ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        HashMap<String, String> map = new HashMap<>();
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String log = st.nextToken();
            
            if(log.equals("enter")) {
                map.put(name, log);
            }
            else if(log.equals("leave")) {
                map.remove(name);
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String x : map.keySet()) list.add(x);
        
        list.sort((a,b) -> b.compareTo(a));
        
        for(String x : list) System.out.println(x); 

    }
    
}


```

해시맵 만들고 배열리스트 까지 만드는건 비효율적임. 이럴바에 순서를 보장해주는 트리셋 만들어서 내림차순만 시켜버리면 됨

---

두번째 풀이, 트리셋, 1004ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder()); // 초기 설정을 내림차순으로
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String log = st.nextToken();
            
            if(log.equals("enter")) {
                set.add(name);
            }
            else if(log.equals("leave")) {
                set.remove(name);
            }
        }
        
        for(String x : set) System.out.println(x);
 

    }
    
}


```

---

StringBuilder + 트리셋, 512ms

```java
import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String log = st.nextToken();
            
            if(log.equals("enter")) {
                set.add(name);
            }
            else if(log.equals("leave")) {
                set.remove(name);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String x : set) sb.append(x).append('\n');
        
        System.out.print(sb);
 

    }
    
}


```

---

![image](https://github.com/user-attachments/assets/580616b2-35c1-4adc-938a-c7469ade234d)

