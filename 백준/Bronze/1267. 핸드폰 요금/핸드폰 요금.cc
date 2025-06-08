#include <bits/stdc++.h>
using namespace std;

int main() {
    
    int n, t; cin >> n;
    
    int M = 0, Y = 0;
    
    for(int i=0; i<n; i++) {
        cin >> t;
        
        M += 15 + (t / 60) * 15;
        
        Y += 10 + (t / 30) * 10;
    }
    
    if(M == Y) 
        cout << "Y M " << M;
    else 
        cout << (M < Y ? "M" : "Y") << ' ' << (M < Y ? M : Y);
}