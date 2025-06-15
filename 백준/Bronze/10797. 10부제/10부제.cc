#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k, ans = 0;
    
    cin >> n;
    
    for(int i=0; i<5; i++) {
        cin >> k;
        if(k == n) ans++;
    }
    
    cout << ans << '\n';
}