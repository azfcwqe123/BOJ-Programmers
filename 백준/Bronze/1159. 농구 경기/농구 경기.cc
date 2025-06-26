#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    int n;
    cin >> n;
    
    int player[26] = {0};
    
    string name;
    for(int i=0; i<n; i++) {
        cin >> name;
        player[name[0] - 'a']++;
    }
    
    bool check = false;
    
    for(int i=0; i<26; i++) {
        if(player[i] >= 5) {
            check = true;
            cout << (char) (i + 'a');
        }
    }
    
    if(!check) {
        cout << "PREDAJA" << '\n';
    }
    
}