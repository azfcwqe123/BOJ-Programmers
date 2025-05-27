#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int T, k;
    
    cin >> T;
    
    while(T--) {
        vector<int> v;
        
        for(int i=0; i<5; i++) {
            cin >> k;
            v.push_back(k); 
        }
   
        sort(v.begin(), v.end());
        
        if(v[3] - v[1] >= 4) cout << "KIN" << '\n';
        
        else cout << v[1] + v[2] + v[3] << '\n';
    }
    
    
    
    
}