# [Silver IV] 한수 - 1065 

[문제 링크](https://www.acmicpc.net/problem/1065) 

### 성능 요약

메모리: 14240 KB, 시간: 108 ms

### 분류

브루트포스 알고리즘, 수학

### 제출 일자

2025년 2월 21일 21:14:13

### 문제 설명

<p>어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. </p>

### 입력 

 <p>첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.</p>

### 출력 

 <p>첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.</p>

---

내 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        for(int i=1; i<=n; i++) {
            if(i < 10) ans++;
            else if(check(String.valueOf(i))) ans++;
        }
        
        System.out.print(ans);
    }
    
    static boolean check(String tmp) {
        
        char[] arr = tmp.toCharArray();
        
        int a = arr[0]; // 첫째항
        int d = (arr[1] - '0') - (arr[0] - '0'); // 등차
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != a + d * i) return false;
        }
        
        return true;
    }
    
}



```

---

참고 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        if(n < 100) { // 100 이하는 모두 각자리수가 등차수열을 이룬다.
            System.out.print(n);
            System.exit(0);
        } else { // 문제의 조건은 1000이하의 자연수니, 백의 자릿수~일의 자릿수를 처리해준다.
            ans = 99;
            
            for(int i=100; i<=n; i++) {
                
                int a = i / 100; // 백의 자릿수
                int b = (i / 10) % 10; // 십의 자릿수
                int c = i % 10; // 일의 자릿수
                
                if(b - a == c - b) ans++;
            }
        }
        
        System.out.print(ans);
        
    }
    
}



```

---

내풀이 + 참고풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        
        if(n < 100) {
            System.out.print(n);
            System.exit(0);
        } else {
            ans = 99;
            for(int i=100; i<=n; i++) {
                if(check(String.valueOf(i))) ans++;
            }
        }
        
        System.out.print(ans);
    }
    
    static boolean check(String tmp) {
        
        char[] arr = tmp.toCharArray();
        
        int a = arr[0];
        int d = (arr[1] - '0') - (arr[0] - '0');
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != a + d * i) return false;
        }
        
        return true;
    }
    
}

```

---

![image](https://github.com/user-attachments/assets/d3d8c4f9-9e96-4aec-872c-d128d48a873a)


