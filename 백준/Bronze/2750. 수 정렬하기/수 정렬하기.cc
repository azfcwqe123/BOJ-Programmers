#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> v;
    
    int n, k;
    cin >> n;
    
    while(n--) {
        cin >> k;
        v.push_back(k);
    }
    
    sort(v.begin(), v.end());
    
    for(int x : v) cout << x << '\n';
    
}