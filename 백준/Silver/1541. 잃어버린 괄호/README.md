# [Silver II] 잃어버린 괄호 - 1541 

[문제 링크](https://www.acmicpc.net/problem/1541) 

### 성능 요약

메모리: 14344 KB, 시간: 104 ms

### 분류

그리디 알고리즘, 수학, 파싱, 문자열

### 제출 일자

2025년 1월 18일 16:38:47

### 문제 설명

<p>세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.</p>

<p>그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.</p>

<p>괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄에 정답을 출력한다.</p>

---

그리디 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String[] arr = br.readLine().split("-");
        
        int ans = 0;
        
        for(int i=0; i<arr.length; i++) {
            
            String[] tmp = arr[i].split("\\+");
            
            if(i==0) for(String k : tmp) ans += Integer.parseInt(k);
            
            else if(i>=1) for(String k : tmp) ans -= Integer.parseInt(k);
            
        }
        
        System.out.print(ans);
        
    }
    
}


```

맨 앞에는 숫자밖에 오지 않는다고 하니, '-' 기호가 붙을 수가 없어 무조건 양수부터 시작이다.
&nbsp;

Stirng 배열 arr으로 입력값을 '-' 기호로 기준으로 배열로 만들었을때, 배열의 길이가 2이상이면 '-'으로 분류돼었다는 뜻이기에 인덱스 1 이상인 문자열에 들어있는 숫자들은 모조리 빼주면 된다.

![image](https://github.com/user-attachments/assets/f30230da-eb71-457c-b37b-d92bb8a01934)


---

![image](https://github.com/user-attachments/assets/af4715e0-7b65-4607-8179-df7b2179d2e5)
