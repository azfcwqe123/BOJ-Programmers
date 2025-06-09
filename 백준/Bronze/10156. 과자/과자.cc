#include <bits/stdc++.h>
using namespace std;

int main() {
    int k, n, m;
    
    cin >> k >> n >> m;
    
    int res = m - k * n;
    
    cout << (res < 0 ? abs(res) : 0);
}