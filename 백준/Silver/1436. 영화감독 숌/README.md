# [Silver V] 영화감독 숌 - 1436 

[문제 링크](https://www.acmicpc.net/problem/1436) 

### 성능 요약

메모리: 85868 KB, 시간: 260 ms

### 분류

브루트포스 알고리즘

### 제출 일자

2024년 12월 22일 12:34:02

### 문제 설명

<p>666은 종말을 나타내는 수라고 한다. 따라서, 많은 블록버스터 영화에서는 666이 들어간 제목을 많이 사용한다. 영화감독 숌은 세상의 종말 이라는 시리즈 영화의 감독이다. 조지 루카스는 스타워즈를 만들 때, 스타워즈 1, 스타워즈 2, 스타워즈 3, 스타워즈 4, 스타워즈 5, 스타워즈 6과 같이 이름을 지었고, 피터 잭슨은 반지의 제왕을 만들 때, 반지의 제왕 1, 반지의 제왕 2, 반지의 제왕 3과 같이 영화 제목을 지었다. 하지만 숌은 자신이 조지 루카스와 피터 잭슨을 뛰어넘는다는 것을 보여주기 위해서 영화 제목을 좀 다르게 만들기로 했다.</p>

<p>종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다. 따라서, 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다. 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수) 와 같다.</p>

<p>숌이 만든 N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.</p>

---


첫번째 풀이, 브루트 포스
```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0, k = 666;

        while(true) {
            
            if(String.valueOf(k).contains("666")) {
                cnt++;
                if(cnt == n) {
                   System.out.print(k);
                   return;
                }
                k++;
            }
            else k++;
        }
        
    }
}

```

---

살짝 수정한 코드

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0, k = 666;

        while(true) {
            
            if(String.valueOf(k).contains("666")) {
                cnt++;
                if(cnt == n) {
                   System.out.print(k);
                   return;
                }
            }
            
            k++; // 이 부분을 더 깔끔하게 수정했다.
        }
        
    }
}

```

---

이 문제는 브루트 포스 알고리즘을 이용해야하는데, 이유는 모든 경우의수를 다 따져볼 수밖에 없기 때문

![image](https://github.com/user-attachments/assets/5edfbfde-5c21-46bb-bd56-6c8f645b4fa4)
