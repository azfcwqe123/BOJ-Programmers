# [Silver I] 신입 사원 - 1946 

[문제 링크](https://www.acmicpc.net/problem/1946) 

### 성능 요약

메모리: 301244 KB, 시간: 1640 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2025년 1월 20일 12:03:51

### 문제 설명

<p>언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.</p>

<p>그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.</p>

<p>이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.</p>

### 출력 

 <p>각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.</p>

---

그리디 알고리즘

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Person {
        int G; // 성적 등수
        int I; // 인터뷰 등수
        
        Person(int G, int I) {
            this.G = G;
            this.I = I;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            ArrayList<Person> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int G = Integer.parseInt(st.nextToken());
                int I = Integer.parseInt(st.nextToken());
                list.add(new Person(G, I));
            }
            
            Collections.sort(list, (a, b) -> a.G - b.G);
            
            int ans = 1, min = list.get(0).I;
            
            for(int i=1; i<n; i++) { // 핵심 코드
                if(list.get(i).I < min) {
                    min = list.get(i).I;
                    ans++;
                }
            }
            
            sb.append(ans).append('\n');
        }
        
        System.out.print(sb);
    }
    
}


```

성적 등수로 오름차순 정렬 한다. 그렇다면 1등부터 n등까지 차례로 정렬될테니, 인터뷰 면접 등수만 체크해주면 된다.

이때 인터뷰 면접 등수 체크를 자신보다 성적 등수가 높은 사람과 비교한다. 자신보다 성적이 낮은 사람들은 체크할 필요가 없기 때문이다(이미 성적에서 우위를 점하고 있음).
&nbsp;

자신보다 성적이 높은 사람들 중에서, 자신보다 높은 면접 점수를 가지고 있으면 성적 점수와 인터뷰 점수 모두 떨어지는 사람이기때문에 탈락한다.
그리고 인터뷰 면접을 높은 성적을 가진 사람으로 계속 최신화 해준다.

![image](https://github.com/user-attachments/assets/fb818b6c-4537-4228-ac45-1ca0b7243796)

---

![image](https://github.com/user-attachments/assets/e0e6d645-2990-4312-a445-ba37781bb9ef)

