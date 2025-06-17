#include <bits/stdc++.h>
using namespace std;

int main() {
    int k, tmp = 0, sum = 0;
    
    for(int i=0; i<4; i++) {
        cin >> k;
        sum += k;
    }
    
    tmp = sum;
    sum = 0;
    
    for(int i=0; i<4; i++) {
        cin >> k;
        sum += k;
    }
    
    cout << max(tmp, sum);
}