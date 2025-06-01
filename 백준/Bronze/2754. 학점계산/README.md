# [Bronze III] 학점계산 - 2754 

[문제 링크](https://www.acmicpc.net/problem/2754) 

### 성능 요약

메모리: 2024 KB, 시간: 0 ms

### 분류

구현, 문자열

### 제출 일자

2025년 6월 1일 14:09:52

### 문제 설명

<p>어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.</p>

<p>A+: 4.3, A0: 4.0, A-: 3.7</p>

<p>B+: 3.3, B0: 3.0, B-: 2.7</p>

<p>C+: 2.3, C0: 2.0, C-: 1.7</p>

<p>D+: 1.3, D0: 1.0, D-: 0.7</p>

<p>F: 0.0</p>

### 입력 

 <p>첫째 줄에 C언어 성적이 주어진다. 성적은 문제에서 설명한 13가지 중 하나이다.</p>

### 출력 

 <p>첫째 줄에 C언어 평점을 출력한다.</p>

 ---

```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    string grade;
    cin >> grade;
    
    double score;
    
    switch(grade[0]) {
        case 'A' : score = 4.0; break;
        case 'B' : score = 3.0; break;
        case 'C' : score = 2.0; break;
        case 'D' : score = 1.0; break;
    }
    
    switch(grade[1]) {
        case '+' : score += 0.3; break;
        case '-' : score -= 0.3; break;
    }
    
    
    cout << fixed << setprecision(1) << score << '\n';
    
}
```

| 조작자                       | 의미                       |
| ------------------------- | ------------------------ |
| `setprecision(n)`         | n자리까지 출력 (기본은 전체 자릿수 기준) |
| `fixed`                   | 소수점 이하 자릿수 기준으로 설정       |
| `fixed + setprecision(n)` | 소수점 아래 n자리까지 고정 출력       |


