#include <bits/stdc++.h>
using namespace std;

int n, m, cnt = 0;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);

    cin >> n;
    cin >> m;

    vector<int> v(n);

    for(int i=0; i<n; i++) {
        cin >> v[i];
    }

    sort(v.begin(), v.end());

    int lt = 0, rt = v.size() - 1;

    while(lt < rt) {
        if(v[lt] + v[rt] == m) {
            lt++; rt--;
            cnt++;
        }
        else if(v[lt] + v[rt] < m) lt++;
        else rt--;
    }

    cout << cnt << '\n';

    return 0;
}