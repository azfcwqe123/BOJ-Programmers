#include <bits/stdc++.h>
using namespace std;

int t, n;
string a, b;

int main() {
    cin >> t;

    while(t--) {
        cin >> n;

        map<string, int> map;

        for(int i=0; i<n; i++) {
            cin >> a >> b;
            map[b]++;
        }

        long long res = 1;

        for(auto x : map) {
            res *= ((long long) x.second + 1);
        }

        res--;

        cout << res << '\n';
    }

}