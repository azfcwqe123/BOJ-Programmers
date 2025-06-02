#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int sum = 0, ans = 0, st, ed;
    
    for(int i=0; i<4; i++) {
        cin >> st >> ed;
        
        sum += ed - st;
        
        ans = max(ans, sum);
    }
    
    cout << ans << '\n';
}