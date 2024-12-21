# [Silver V] 단어 나누기 - 1251 

[문제 링크](https://www.acmicpc.net/problem/1251) 

### 성능 요약

메모리: 17212 KB, 시간: 160 ms

### 분류

브루트포스 알고리즘, 구현, 정렬, 문자열

### 제출 일자

2024년 12월 21일 17:21:05

### 문제 설명

<p>알파벳 소문자로 이루어진 단어를 가지고 아래와 같은 과정을 해 보려고 한다.</p>

<p>먼저 단어에서 임의의 두 부분을 골라서 단어를 쪼갠다. 즉, 주어진 단어를 세 개의 더 작은 단어로 나누는 것이다. 각각은 적어도 길이가 1 이상인 단어여야 한다. 이제 이렇게 나눈 세 개의 작은 단어들을 앞뒤를 뒤집고, 이를 다시 원래의 순서대로 합친다.</p>

<p>예를 들어,</p>

<ul>
	<li>단어 : arrested</li>
	<li>세 단어로 나누기 : ar / rest / ed</li>
	<li>각각 뒤집기 : ra / tser / de</li>
	<li>합치기 : ratserde</li>
</ul>

<p>단어가 주어지면, 이렇게 만들 수 있는 단어 중에서 사전순으로 가장 앞서는 단어를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 영어 소문자로 된 단어가 주어진다. 길이는 3 이상 50 이하이다.</p>

### 출력 

 <p>첫째 줄에 구하고자 하는 단어를 출력하면 된다.</p>

---

브루트 포스 

```java
import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        String str = br.readLine();
        
        int L = str.length();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=1; i<L-1; i++) {
            
            for(int j=i+1; j<L; j++) {
                
                String a = new StringBuilder(str.substring(0, i)).reverse().toString();
                String b = new StringBuilder(str.substring(i, j)).reverse().toString();
                String c = new StringBuilder(str.substring(j, L)).reverse().toString();
                
                list.add(a + b + c);
                
            }
        }
        
        list.sort((a,b) -> a.compareTo(b));
        
        System.out.print(list.get(0));
        
    }
}




```
주어진 단어를 세 개의 더 작은 단어로 나누는 것이다. 각각은 적어도 길이가 1 이상인 단어여야 한다고 문제에서 설명한다.
&nbsp;

abcdefg의 문자열이 있다고 가정해보자.
&nbsp;

첫시작은 a / b / cdefg로 나눈다. 그렇다면 첫번째 for문에서의 변수는 i=1로 시작해야한다. substring(0,j)에 부합해야하기 때문
그리고 두번째 for문에서의 변수는 j=i+1로 시작해야한다. substring(i,j)을 substring(1,2)로 생각해보자. 두번째 문자열만 딱 자르게 된다.
&nbsp;

세번째는 문자열 전까지만 자르면 되기에, L = str.length()의 길이를 사용하면 된다.
&nbsp;

브루트포스 알고리즘을 활용하기 위해 문자열을 자르는 경우의수를 생각해봤다.

---

![image](https://github.com/user-attachments/assets/9ef8f455-e708-4a16-addd-1662ec7f2c50)

