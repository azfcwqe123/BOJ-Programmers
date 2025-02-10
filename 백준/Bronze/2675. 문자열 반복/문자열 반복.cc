#include <iostream>
#include <string.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int T;
    cin >> T;
    
    while(T--) {
        int r;
        string str;
        cin >> r >> str;
        
        for(int i=0; i<str.length(); i++) {
            for(int j=0; j<r; j++) {
                cout << str[i];
            }
        }
        cout << '\n';
    }
    
}