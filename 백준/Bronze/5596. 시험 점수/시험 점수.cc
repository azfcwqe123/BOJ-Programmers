#include <bits/stdc++.h>
using namespace std;

int main() {
    int a, b, c, d;
    int sum[2] = {0};
    
    for(int i=0; i<2; i++) {
        cin >> a >> b >> c >> d;
        sum[i] = a + b + c + d;
    }
    
    cout << max(sum[0], sum[1]);
} 