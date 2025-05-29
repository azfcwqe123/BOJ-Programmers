#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int alpha[26] = {0};
    
    string str;
    cin >> str;
    
    for(char ch : str) {
        alpha[ch - 'a']++;
    }
    
    
    for(int x : alpha) cout << x << " ";
}