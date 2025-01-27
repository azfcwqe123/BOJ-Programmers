# [Silver III] 팰린드롬 만들기 - 1213 

[문제 링크](https://www.acmicpc.net/problem/1213) 

### 성능 요약

메모리: 16308 KB, 시간: 136 ms

### 분류

그리디 알고리즘, 구현, 문자열

### 제출 일자

2025년 1월 27일 14:30:55

### 문제 설명

<p>임한수와 임문빈은 서로 사랑하는 사이이다.</p>

<p>임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.</p>

<p>임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.</p>

<p>임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.</p>

### 출력 

 <p>첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.</p>

---

문자열

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int[] alpha = new int[26];
        
        String str = br.readLine();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            alpha[ch - 65]++;
        }
        
        int cnt = 0;
        
        for(int i=0; i<26; i++) {
            if(alpha[i] % 2 == 1) cnt++;
            
            if(cnt > 1) { // 홀수가 2개 이상이면 끝낸다.
                System.out.print("I'm Sorry Hansoo");
                System.exit(0);
            }
        }
        
        
        for(int i=0; i<26; i++) {
            
            if(alpha[i] == 0) continue; // 표기가 안 된 알파벳은 PASS
            
            else { // 짝수든 홀수는 2로 나눈 몫을 문자열에 추가해준다.
                char ch = (char) (i + 65);
                sb.append(String.valueOf(ch).repeat(alpha[i] / 2)); 
            } // A 하나면 추가가 안 되고, AAA면 A 하나가 추가 된다. BB면 1개, BBBB면 2개임. 대칭성을 맞추기 위함이다.
        }
        
        
        String tmp = new StringBuilder(sb).reverse().toString();
        
        // 마지막 홀수 하나를 찾아서 더해주고,
        for(int i=0; i<26; i++) {
            if(alpha[i] % 2 == 1) {
                sb.append((char) (i+65));
                break;
            }
        }
        
        sb.append(tmp); // 뒤집어놨던 문자열을 덧붙여준다.
        
        System.out.print(sb);
        
    }
}

/*
// 홀수가 2개 이상 나오면 안됨.
A - > 가능(홀수 1)
AB -> 불가능 (홀수 2)
AAAB -> 불가능(홀수 2)
AAABB -> 가능(홀수 1, 짝수 1)
AAABBB -> 불가능 (홀수3)
BBAAC - > ABCBA 가능 (홀수1, 짝수2)
BBAACCD -> ABCDCBA 가능(홀수1, 짝수3)
BBBBA -> BBABB 가능(홀수1, 짝수2)*/

```
그리디 알고리즘보다는 문자열 구현에 더 가까웠던 문제

---

![image](https://github.com/user-attachments/assets/74c0a6fb-7c78-4587-ad21-318d1e837277)
