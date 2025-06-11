#include <bits/stdc++.h>
using namespace std;

int main() {
    
    string str;
    
    while(true) {
        getline(cin, str);
        
        if(str == "END") return 0;
        
        for(int i=str.length() - 1; i>=0; i--) cout << str[i];
        
        cout << '\n';
    }
    
}