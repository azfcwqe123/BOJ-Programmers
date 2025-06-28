#include <bits/stdc++.h>
using namespace std;

int T, ans;
string word;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);

    cin >> T;

    while(T--) {
        stack<char> s;
        cin >> word;        

        for(int i=0; i<word.size(); i++) {
            if(s.empty()) s.push(word[i]);
            else if(s.top() == word[i]) s.pop();
            else s.push(word[i]);
        }

        if(s.size() == 0) ans++;
    }

    cout << ans << '\n';
}