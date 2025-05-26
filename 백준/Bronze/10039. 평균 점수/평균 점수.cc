#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int a, sum = 0;
    
    while(cin >> a) {
        sum += (a < 40) ? 40 : a;
    }
    
    cout << sum / 5;
}