#include <bits/stdc++.h>
using namespace std;

int recur(int n) {
    if(n == 0) return 1;
    
    return n * recur(n-1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n;
    
    cin >> n;
    
    cout << recur(n);
}