#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n, sum;
    
    cin >> n;
    
    sum = n * (n + 1) / 2;
    
    cout << sum << '\n' << sum * sum << '\n' << sum * sum;
}