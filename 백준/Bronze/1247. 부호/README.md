# [Bronze III] 부호 - 1247 

[문제 링크](https://www.acmicpc.net/problem/1247) 

### 성능 요약

메모리: 2020 KB, 시간: 68 ms

### 분류

수학, 사칙연산, 임의 정밀도 / 큰 수 연산

### 제출 일자

2025년 5월 28일 11:23:24

### 문제 설명

<p>N개의 정수가 주어지면, 이 정수들의 합 S의 부호를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>총 3개의 테스트 셋이 주어진다. 각 테스트 셋의 첫째 줄에는 N(1 ≤ N ≤ 100,000)이 주어지고, 둘째 줄부터 N개의 줄에 걸쳐 각 정수가 주어진다. 주어지는 정수의 절댓값은 9223372036854775807보다 작거나 같다.</p>

### 출력 

 <p>총 3개의 줄에 걸쳐 각 테스트 셋에 대해 N개의 정수들의 합 S의 부호를 출력한다. S=0이면 "0"을, S>0이면 "+"를, S<0이면 "-"를 출력하면 된다.</p>

---
오버플로우, 언더플로우

```cpp
#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    for(int i=0; i<3; i++) {
        int n, flow = 0; // flow -> 오버플로우, 언더플로우 확인 용도
        cin >> n;
        
        ll tmp, sum = 0;
        while(n--) {
            cin >> tmp; // 현재 입력받는 값
            
            ll prevSum = sum; // 이전 sum
            
            sum += tmp;  // 현재 sum에 갱신
            
            if(tmp > 0 && prevSum > 0 && sum < 0) flow++; // 오버플로우
            else if(tmp < 0 && prevSum < 0 && sum > 0) flow--; // 언더플로우
        }
        
        if(flow == 0) cout << (sum == 0 ? '0' : (sum > 0 ? '+' : '-')) << '\n'; // 오버, 언더플로우 발생 X
        else cout << (flow > 0 ? '+' : '-') << '\n'; // 발생 O
    }
}
```

---

![image](https://github.com/user-attachments/assets/467a4e4b-b239-4a3f-a188-89eed7adfc0c)
