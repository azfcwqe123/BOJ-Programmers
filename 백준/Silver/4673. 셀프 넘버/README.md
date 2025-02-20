# [Silver V] 셀프 넘버 - 4673 

[문제 링크](https://www.acmicpc.net/problem/4673) 

### 성능 요약
 
메모리: 14024 KB, 시간: 100 ms

### 분류

브루트포스 알고리즘, 구현, 수학

### 제출 일자

2025년 2월 20일 22:03:42

### 문제 설명

<p>셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.</p>

<p>양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. </p>

<p>예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다.</p>

<p>33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...</p>

<p>n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. </p>

<p>생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97</p>

<p>10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>입력은 없다.</p>

### 출력 

 <p>10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.</p>

---

내 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        boolean[] arr = new boolean[10100];
        
        for(int i=1; i<10000; i++) {
            arr[check(i)] = true;
            if(!arr[i]) sb.append(i).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int check(int n) {
        int sum = n;
        
        while(n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        
        return sum;
    }
    
}


```

배열을 10100으로 설정한 이유: 9999은 9999 + 9 + 9 + 9 + 9의 생성자이므로, 최대범위가 10035이기 때문에 설정함.

어차피 10000 넘어가는건 무시하면 되니 일단 담고 봤음. 아래와 같이 if문을 통해서 처리할 수도 있다.

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        boolean[] arr = new boolean[10001];
        
        for(int i=1; i<10000; i++) {
            int tmp = check(i);
            
            if(tmp < 10000) arr[check(i)] = true;
            
            if(!arr[i]) sb.append(i).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int check(int n) {
        int sum = n;
        
        while(n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        
        return sum;
    }
    
}


```

---

셀프넘버만 체크하기 위해서는 boolean 배열을 사용하는게 간편할것같다고 생각했다.

다른사람들도 boolean 배열을 사용해서 푸는거 옳게 푼 것 같다.
![image](https://github.com/user-attachments/assets/64718308-e6e4-4db0-b924-6c3b5066ed09)
