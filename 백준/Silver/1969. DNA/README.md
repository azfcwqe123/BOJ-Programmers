# [Silver IV] DNA - 1969 

[문제 링크](https://www.acmicpc.net/problem/1969) 

### 성능 요약

메모리: 14284 KB, 시간: 112 ms

### 분류

브루트포스 알고리즘, 그리디 알고리즘, 구현, 문자열

### 제출 일자

2025년 1월 26일 16:05:27

### 문제 설명

<p>DNA란 어떤 유전물질을 구성하는 분자이다. 이 DNA는 서로 다른 4가지의 뉴클레오티드로 이루어져 있다(Adenine, Thymine, Guanine, Cytosine). 우리는 어떤 DNA의 물질을 표현할 때, 이 DNA를 이루는 뉴클레오티드의 첫글자를 따서 표현한다. 만약에 Thymine-Adenine-Adenine-Cytosine-Thymine-Guanine-Cytosine-Cytosine-Guanine-Adenine-Thymine로 이루어진 DNA가 있다고 하면, “TAACTGCCGAT”로 표현할 수 있다. 그리고 Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다. 만약에 “AGCAT"와 ”GGAAT"는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.</p>

<p>우리가 할 일은 다음과 같다. N개의 길이 M인 DNA s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>n</sub>가 주어져 있을 때 Hamming Distance의 합이 가장 작은 DNA s를 구하는 것이다. 즉, s와 s<sub>1</sub>의 Hamming Distance + s와 s<sub>2</sub>의 Hamming Distance + s와 s<sub>3</sub>의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.</p>

### 입력 

 <p>첫 줄에 DNA의 수 N과 문자열의 길이 M이 주어진다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 DNA가 주어진다. N은 1,000보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 Hamming Distance의 합이 가장 작은 DNA 를 출력하고, 둘째 줄에는 그 Hamming Distance의 합을 출력하시오. 그러한 DNA가 여러 개 있을 때에는 사전순으로 가장 앞서는 것을 출력한다.</p>

---

그리디 알고리즘, 브루트 포스

첫번째 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] DNA = new String[n];
        
        for(int i=0; i<n; i++) DNA[i] = br.readLine();
        
        int sum = 0;
        
        for(int i=0; i<m; i++) {
            int[] ACGT = new int[4];
            
            for(int j=0; j<n; j++) {
                
                switch(DNA[j].charAt(i)) {
                    
                    case 'A' : 
                        ACGT[0]++;
                        break;
                        
                    case 'C' :
                        ACGT[1]++;
                        break;
                        
                    case 'G' :
                        ACGT[2]++;
                        break;
                        
                    case 'T' :
                        ACGT[3]++;
                        break;
                }
            }
            
            int max = ACGT[0], idx = 0;
            
            for(int k=1; k<4; k++) {
                if(max < ACGT[k]) {
                    max = ACGT[k];
                    idx = k;
                }
            }
            
            sum += n - max;
            
            switch(idx) {
                case 0 :
                    sb.append('A');
                    break;
                
                case 1 :
                    sb.append('C');
                    break;
                
                case 2 :
                    sb.append('G');
                    break;
                    
                case 3 :
                    sb.append('T');
                    break;
            }
            
        }
        
        System.out.println(sb);
        System.out.println(sum);
    }
    
}


```

---

두번째 풀이

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] DNA = new String[n];
        
        for(int i=0; i<n; i++) DNA[i] = br.readLine();
        
        int sum = 0;
        
        for(int i=0; i<m; i++) {
            int A = 0, T = 0, G = 0, C = 0; // 해시맵 쓰기 좀 번거로운 상황일땐, 이렇게 쓰는것도 정말 좋은듯
            
            for(int j=0; j<n; j++) {
                
                switch(DNA[j].charAt(i)) {
                    
                    case 'A' : 
                        A++;
                        break;
                        
                    case 'T' :
                        T++;
                        break;
                        
                    case 'G' :
                        G++;
                        break;
                        
                    case 'C' :
                        C++;
                        break;
                }
            }
            
            int max = Math.max(Math.max(A, T), Math.max(G, C));
            sum += n - max;
            
            char ch = max == A ? 'A' : max == C ? 'C' : max == G ? 'G' : 'T';
            
            sb.append(ch);
        }
        
        System.out.println(sb);
        System.out.println(sum);
    }
    
}


```

---

참고 블로그: https://lotuslee.tistory.com/38

계속 틀렸던 이유 : Hamming Distance가 같을 경우에는 오름차순으로 정렬해야하는데, 그걸 깜빡함

솔직히 문제 자체를 이해하긴 어려웠다. 무슨말인지 몰라서 다른 사람 블로그 보고 이해했다. 그리고 개인적으로는 그리디 알고리즘보다는 구현 + 브루트포스 알고리즘과 더 가까운 유형이었던것같다.

![image](https://github.com/user-attachments/assets/975642c6-b137-406a-b0c5-1f1619ebe7e3)
