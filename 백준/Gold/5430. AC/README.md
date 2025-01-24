# [Gold V] AC - 5430 

[문제 링크](https://www.acmicpc.net/problem/5430) 

### 성능 요약

메모리: 99524 KB, 시간: 756 ms

### 분류

덱, 파싱, 구현, 문자열, 자료 구조

### 제출 일자

2025년 1월 25일 00:03:18

### 문제 설명

<p>선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.</p>

<p>함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.</p>

<p>함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.</p>

<p>배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.</p>

<p>각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.</p>

<p>다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)</p>

<p>다음 줄에는 [x<sub>1</sub>,...,x<sub>n</sub>]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ x<sub>i</sub> ≤ 100)</p>

<p>전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.</p>

### 출력 

 <p>각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.</p>

---

첫번째 풀이(오답), 시간초과

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            String str = br.readLine().replace("[", "").replace("]", "");
            
            boolean check = true;
            
            for(char x : func.toCharArray()) {
                
                if(str.length() == 0) {
                    check = false;
                    break;
                }
                
                else if(x == 'R') str = R(str);
                
                else if(x == 'D') str = D(str);
            }
            
            if(check) sb.append("[" + str + "]");
            else sb.append("error");
            
            sb.append('\n');
        }
        
        System.out.print(sb);
        
    }
    
    static String R(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    static String D(String str) {
        int k = str.indexOf(",");
        
        if(k == -1) return ""; // 배열의 원소가 하나밖에 없는 경우
        
        return str.substring(k+1);
    }
}

```
테스트케이스는 잘 작동하지만 시간초과가 발생한다. 덱을 사용해서 풀어야함

이 문제를 풀면서 고민했던건,

1. [1, 2, 3, 4, 5]와 같이 한자리 자연수만 나오는게 아니고 [10, 20, 30] 같은 배열도 나올 수 있다는걸 눈치채야한다. 이 배열을 뒤집으면 03 ,02 ,01 같은 의도치 않은 값으로 만들어버릴 위험이 있음.

2. 내가 쓴 풀이는 숫자 하나밖에 없는 경우도 따져줘야한다. 덱으로 풀면 'D'가 나왔을때, 그냥 요소를 지워버리면 끝이기 때문에 간단함

---

두번째 풀이, 덱 사용

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            Deque<Integer> deque = new LinkedList<>();
            
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            String str = br.readLine();
            for(String s : str.substring(1, str.length() - 1).split(",")) {
                if(!s.equals("")) deque.add(Integer.valueOf(s));
            }
            
            sb.append(solution(deque, func)).append('\n');
            
        }
        
        System.out.print(sb);
        
    }
    
    static String solution(Deque<Integer> deque, String func) {
        
        boolean reverse = false;
        
        for(char x : func.toCharArray()) {
            
            if(x == 'R') reverse = !reverse; // 핵심
            
            else if(x == 'D') {
                
                if(deque.size() == 0) return "error";
                
                if(reverse) deque.removeLast();
                
                else deque.removeFirst();
            }
        }
        
        StringBuilder tmp = new StringBuilder("[");
        
        while(!deque.isEmpty()) {
            tmp.append(reverse ? deque.removeLast() : deque.removeFirst());
            
            if(deque.size() != 0) tmp.append(",");
        }
        
        tmp.append("]");
        
        return tmp.toString();
    }
    
}

```
덱의 사용법과 원리를 안다면 쉽게 풀 수 있는 문제인듯하다. 블로그 풀이가 직관적이고 마음에 들었다.

참고: https://girawhale.tistory.com/9

---

![image](https://github.com/user-attachments/assets/f3da647b-62e2-4b9e-af35-4f85a7f27920)
