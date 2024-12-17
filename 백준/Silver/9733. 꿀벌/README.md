# [Silver V] 꿀벌 - 9733 

[문제 링크](https://www.acmicpc.net/problem/9733) 

### 성능 요약

메모리: 16344 KB, 시간: 136 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 구현, 문자열

### 제출 일자

2024년 12월 18일 00:53:42

### 문제 설명

<p>꿀벌이 하는 일은 다음과 같이 분류할 수 있다.</p>

<p>휴식(Re), 순찰(Pt), 방청소(Cc), 꽃가루 먹기(Ea), 새끼 돌보기(Tb), 벌집 짓기와 관리(Cm), 외부 활동(Ex)</p>

<p>한 꿀벌이 1시간 동안 한 일이 주어졌을 때, 각각을 몇 번 했고, 비율이 어떻게 되는지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>입력은 꿀벌이 한 일이 공백과 줄바꿈으로 구분되어서 주어진다. 최대 24개의 일을 한다.</p>

### 출력 

 <p>각각의 일을 한 횟수와 비율을 공백으로 구분하여 출력한다. 출력은 {Re,Pt,Cc,Ea,Tb,Cm,Ex} 순서대로 하며, 비율은 소수점 둘째 자리까지 출력한다. 주어진 목록에 없는 일은 출력하지 않는다.</p>

<p>입력의 마지막 줄에는 "Total <total> 1.00"을 출력하며, <total>은 꿀벌이 한 일의 개수이다.</p>

---

LinkedHashMap 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>() {{
            put("Re", 0);
            put("Pt", 0);
            put("Cc", 0);
            put("Ea", 0);
            put("Tb", 0);
            put("Cm", 0);
            put("Ex", 0);
        }};
        
        int total = 0;
        
        String input = "";
        
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            
            while(st.hasMoreTokens()) {
                String bee = st.nextToken();
                if(map.containsKey(bee)) map.put(bee, map.get(bee) + 1);
                total++;            
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String x : map.keySet()) {
            
            String per = String.format("%.2f", (double) map.get(x) / total);
            
            sb.append(x + " ").append(map.get(x) + " ").append(per + " ").append("\n");
        }
        
        sb.append("Total " + total + " 1.00");
        System.out.print(sb);
        

    }
    
}


```

---

HashMap 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static final String[] arr = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
    private static HashMap<String, Integer> map = new HashMap<>();
    private static int total = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        setBee();
        
        String input = "";
        
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            
            while(st.hasMoreTokens()) {
                String bee = st.nextToken();
                if(map.containsKey(bee)) map.put(bee, map.get(bee) + 1);
                total++;            
            }
        }
        
        StringBuilder sb = new StringBuilder();
            
        for(int i=0; i<7; i++) {
            String key = arr[i];
            
            String per = String.format("%.2f", (double) map.get(key) / total);
            
            sb.append(key + " " + map.get(key) + " " + per).append("\n");
            
        }
        
        sb.append("Total " + total + " 1.00");
        System.out.print(sb);
        
    }
    
    public static void setBee() {
        for(int i=0; i<7; i++) map.put(arr[i], 0);
    }
    
}


```

---

틀렸던 풀이(출력값은 제대로 나왔으나, 입력 값을 받을 때 두번 반복해서 받는거로 처리하니까 틀렸음)

```java
import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>() {{
            put("Re", 0);
            put("Pt", 0);
            put("Cc", 0);
            put("Ea", 0);
            put("Tb", 0);
            put("Cm", 0);
            put("Ex", 0);
        }};
        
        int total = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            String bee = st.nextToken();
            if(map.containsKey(bee)) map.put(bee, map.get(bee) + 1);
             total++;    
        }
        
        st = new StringTokenizer(br.readLine()); // 이걸 두번 반복함
        while(st.hasMoreTokens()) {
            String bee = st.nextToken();
            if(map.containsKey(bee)) map.put(bee, map.get(bee) + 1);
            total++;    
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(String x : map.keySet()) {
            
            String per = String.format("%.2f", (double) map.get(x) / total);
            
            sb.append(x + " ").append(map.get(x) + " ").append(per + " ").append("\n");
        }
        
        sb.append("Total " + total + " 1.00");
        System.out.print(sb);
        

    }
    
}


```

![image](https://github.com/user-attachments/assets/ce8d49a0-63eb-4aaa-8785-2ab037859639)
