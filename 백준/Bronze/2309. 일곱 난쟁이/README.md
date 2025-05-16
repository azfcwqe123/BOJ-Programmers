# [Bronze I] 일곱 난쟁이 - 2309 

[문제 링크](https://www.acmicpc.net/problem/2309) 

### 성능 요약

메모리: 2020 KB, 시간: 0 ms

### 분류

브루트포스 알고리즘, 정렬

### 제출 일자

2025년 5월 16일 21:07:21

### 문제 설명

<p>왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.</p>

<p>아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.</p>

<p>아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.</p>

### 입력 

 <p>아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.</p>

### 출력 

 <p>일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.</p>

---

순열 9C7

```C++
#include <bits/stdc++.h>
using namespace std;

int a[9];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    for(int i=0; i<9; i++) cin >> a[i];
    
    sort(a, a + 9);
    
    do {
        int sum = 0;
        
        for(int i=0; i<7; i++) sum += a[i];
        
        if(sum == 100) break;
        
    } while(next_permutation(a, a + 9));
    
    for(int i=0; i<7; i++) cout << a[i] << "\n";
    
    return 0;
}
```

---

9C2

```C++
#include <bits/stdc++.h>
using namespace std;

int a[9], sum = 0;
vector<int> v;
pair<int, int> ret;

void solve() { 
    for(int i = 0; i < 9; i++) { // 핵심 코드
        for(int j=0; j<i; j++) {
            if(sum - a[i] - a[j] == 100) {
                ret = {i, j};
                return;
            }
        }
    }    
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
   for(int i=0; i<9; i++) {
       cin >> a[i]; 
       sum += a[i];
   }
   
   solve();
   
   for(int i=0; i<9; i++) {
       if(ret.first == i || ret.second == i) continue;
       v.push_back(a[i]);
   }
   
   sort(v.begin(), v.end());
   
   for(int x : v) cout << x << "\n";
   
   return 0;
}
```

---

재귀

```C++
#include <bits/stdc++.h>
using namespace std;

int a[9];
int n = 9, r = 7;

void check() {
    int sum = 0;
    for(int i=0; i<r; i++) {
        sum += a[i];
    }
    if(sum == 100) {
        sort(a, a + 7);
        for(int i=0; i<r; i++) cout << a[i] << "\n";
        exit(0);
    }
}

void makePermutation(int n, int r, int depth) {
    if(r == depth) {
        check();
        return;
    }
    
    for(int i=depth; i<n; i++) {
        swap(a[i], a[depth]);
        makePermutation(n, r, depth + 1);
        swap(a[i], a[depth]);
    }
    
    return;
}

int main() {
    for(int i=0; i<n; i++) cin >> a[i];
    
    makePermutation(n, r, 0);
    
    return 0;
}
```

---
오답 코드

```C++
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> v(9);
    
    for(int i=0; i<9; i++) {
        cin >> v[i];
    }
    
    sort(v.begin(), v.end());
    
    int sum = 0;
    
    for(int i=0; i<3; i++) {
        for(int j=i+1; j<4; j++) {
            for(int k=j+1; k<5; k++) {
                for(int l=k+1; l<6; l++) {
                    for(int m=l+1; m<7; m++) {
                        for(int n=m+1; n<8; n++) {
                            for(int o=n+1; o<9; o++) {
                                sum = v[i] + v[j] + v[k] + v[l] + v[m] + v[n] + v[o];
                                
                                if(sum == 100) {
                                    cout << v[i] << '\n';
                                    cout << v[j] << '\n';
                                    cout << v[k] << '\n';
                                    cout << v[l] << '\n';
                                    cout << v[m] << '\n';
                                    cout << v[n] << '\n';
                                    cout << v[o] << '\n';
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
}

```
뭔가 이렇게 풀면 딱봐도 틀릴것 같았지만, 마땅히 떠오르지않아 이런식으로 풀어봄. 좋은 경험이었다

---

![image](https://github.com/user-attachments/assets/b8da5938-2edf-4ebd-9b76-6cdcd00d9cf2)

