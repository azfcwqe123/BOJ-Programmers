#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    string s;
    getline(cin, s);
    
    for(char x : s) {
        if('a' <= x && x <= 'z') cout << (char) ((x - 'a' + 13) % 26 + 'a');
        else if('A' <= x && x <= 'Z') cout << (char) ((x - 'A' + 13) % 26 + 'A');
        else cout << x;
    }
}