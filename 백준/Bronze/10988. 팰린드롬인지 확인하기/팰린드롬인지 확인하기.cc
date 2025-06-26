#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    string str;
    cin >> str;
    
    int lt=0, rt=str.length() - 1;
    
    while(lt < rt) {
        
        if(str[lt] != str[rt]) {
            cout << 0 << '\n';
            return 0;
        }    
        
        lt++;
        rt--;
    }
    
    cout << 1 << '\n';
    
}