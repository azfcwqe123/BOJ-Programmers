#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int tmp, min_h = 2001, min_c = 2001;
    
    for(int i=0; i<3; i++) {
        cin >> tmp;
        min_h = min_h > tmp ? tmp : min_h;
    }
    
    for(int i=0; i<2; i++) {
        cin >> tmp;
        min_c = min_c > tmp ? tmp : min_c;
    }
    
    cout << min_h + min_c - 50 << endl;
    
}