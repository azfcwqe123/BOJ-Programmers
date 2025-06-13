#include <bits/stdc++.h>
using namespace std;

int main() {
    int T, a, b, c, maxSum = 0; cin >> T;
    
    while(T--) {
        cin >> a >> b >> c;
        
        if(a==b && b==c && c==a) maxSum = max(maxSum, 10000 + a * 1000);
        else if(a == b) maxSum = max(maxSum, 1000 + a * 100);
        else if(b == c) maxSum = max(maxSum, 1000 + b * 100);
        else if(c == a) maxSum = max(maxSum, 1000 + c * 100);
        else maxSum = max(maxSum, max(a, max(b, c)) * 100);
    }
    
    cout << maxSum << '\n';
}