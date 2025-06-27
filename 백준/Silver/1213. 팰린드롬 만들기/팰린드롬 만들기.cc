#include <bits/stdc++.h>
using namespace std;

string s, res;
int cnt[128], flag = 0;
char mid;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);

    cin >> s;
    
    for(char x : s) cnt[x]++;

    for(int i = 'Z'; i >= 'A'; i--) {
        if(cnt[i]) {
            if(cnt[i] & 1) {
                mid = char(i);
                flag++;
                cnt[i]--;
            }

            if(flag == 2) {
                cout << "I'm Sorry Hansoo\n"; 
                return 0;
            }

            for(int j=0; j<cnt[i]; j+=2) {
                res = char(i) + res;
                res += char(i);
            }
        }
    }

    if(mid) res.insert(res.begin() + res.size() / 2, mid);
    cout << res << '\n';
}