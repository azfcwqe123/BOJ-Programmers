#include <bits/stdc++.h>
using namespace std;

int main() {
    int T;
    cin >> T;
    string str;
    
    while(T--) {

        cin >> str;
        
        for(int i=0; i<str.length(); i++) {
            if(isupper(str[i])) str[i] = tolower(str[i]);
        }
        
        cout << str << '\n';
    }
}