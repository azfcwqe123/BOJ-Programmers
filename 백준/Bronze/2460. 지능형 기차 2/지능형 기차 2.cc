#include <bits/stdc++.h>
using namespace std;

int main() {
    int m, n, sum = 0, maxSum = 0;
    
    for(int i=0; i<10; i++) {
        cin >> m >> n;    
        
        sum += n - m;
        
        maxSum = max(maxSum, sum);
    }
    
    cout << maxSum;
}