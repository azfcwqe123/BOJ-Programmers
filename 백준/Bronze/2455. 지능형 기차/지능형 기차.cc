#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int sum = 0, max, st, ed;
    
    cin >> st >> ed;
    
    sum = max = ed;
    
    for(int i=0; i<3; i++) {
        cin >> st >> ed;
        
        sum -= st;
        sum += ed;
        
        max = sum > max ? sum : max;
    }
    
    cout << max;
}