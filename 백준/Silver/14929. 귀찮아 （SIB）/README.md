# [Silver V] 귀찮아 (SIB) - 14929 

[문제 링크](https://www.acmicpc.net/problem/14929) 

### 성능 요약

메모리: 24816 KB, 시간: 248 ms

### 분류

수학, 누적 합

### 제출 일자

2025년 3월 21일 22:42:27

### 문제 설명

<p><mjx-container class="MathJax" jax="CHTML" display="true" style="font-size: 109%; position: relative;"> <mjx-math display="true" class="MJX-TEX" aria-hidden="true" style="margin-left: 0px; margin-right: 0px;"><mjx-munder><mjx-row><mjx-base style="padding-left: 0.831em;"><mjx-mo class="mjx-lop"><mjx-c class="mjx-c2211 TEX-S2"></mjx-c></mjx-mo></mjx-base></mjx-row><mjx-row><mjx-under style="padding-top: 0.167em;"><mjx-texatom size="s" texclass="ORD"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44E TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c3C"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D44F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45B TEX-I"></mjx-c></mjx-mi></mjx-texatom></mjx-under></mjx-row></mjx-munder><mjx-texatom space="2" texclass="ORD"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D465 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D44E TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D465 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D44F TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-texatom></mjx-math><mjx-assistive-mml unselectable="on" display="block"><math xmlns="http://www.w3.org/1998/Math/MathML" display="block"><munder><mo data-mjx-texclass="OP">∑</mo><mrow data-mjx-texclass="ORD"><mn>1</mn><mo>≤</mo><mi>a</mi><mo><</mo><mi>b</mi><mo>≤</mo><mi>n</mi></mrow></munder><mrow data-mjx-texclass="ORD"><msub><mi>x</mi><mi>a</mi></msub><msub><mi>x</mi><mi>b</mi></msub></mrow></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">\[\sum_{1 \le a < b \le n}{x_ax_b}\]</span> </mjx-container></p>

### 입력 

 <p>n과 x<sub>i</sub>가 주어짇나. n은 10만 이하ㅇ고, x<sub>i</sub>는 젗ㄹ댓값이 100이하인 정수디이다.</p>

### 출력 

 <p>위에서 구하란 걸 구하면 된ㄷ.</p>

---

누적합

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        
        long ans = 0;
        
        for(int i=2; i<=n; i++) {
            ans += arr[i] * sum[i-1];
        }
        
        System.out.print(ans);
    }
    
}


```

n이 4, xi가 1 2 3 4으로 값이 주어졌을때

&nbsp;

(1, 2) (1, 3) (1, 4)

(2, 3) (2, 4)

(3, 4)

같은 규칙이 주어지고, 이를 대각선으로 묶으면

2 * (1)

3 * (1 + 2)

4 * (1 + 2 + 3)

으로 arr의 2번째 요소부터 시작하고, 누적합의 n-1번째까지 사용하는 규칙을 찾을수있다.

---

n이 10만이고 xi가 100이라면 int형 범위를 초과하기에, long ans으로 설정해야함

![image](https://github.com/user-attachments/assets/2410c384-fea2-454a-bc74-0f8dccdc60bc)

