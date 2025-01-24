# [Silver III] 서로 다른 부분 문자열의 개수 - 11478 

[문제 링크](https://www.acmicpc.net/problem/11478) 

### 성능 요약

메모리: 227024 KB, 시간: 660 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 문자열, 트리를 사용한 집합과 맵

### 제출 일자

2025년 1월 24일 22:37:28

### 문제 설명

<p>문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.</p>

<p>부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.</p>

<p>예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.</p>

### 입력 

 <p>첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.</p>

### 출력 

 <p>첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다.</p>

---

문자열 + 해시셋

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int n = str.length();
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String tmp = str.substring(i, j+1);
                set.add(tmp);
            }
        }
        
        System.out.print(set.size());
    }
    
}

```

처음에 a, b, c, d, e, ab, bc, cd, de, abc, bcd, cde 이런식으로 구할 방법이 없을까 생각하다가 아무래도 옳지 않은 방법이어서 다시 생각해본 결과,

a, ab, abc, abcd, abcde, b, bc, bcd, bcde ... 식으로 가는걸 깨달았다. 별찍기 문제가 생각났던 문제

---

![image](https://github.com/user-attachments/assets/df47e13d-e866-4368-b6a8-35bf1be22d70)
