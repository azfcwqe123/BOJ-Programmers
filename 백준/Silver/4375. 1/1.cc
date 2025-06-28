#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int n;

int main() {
    
    while(cin >> n) {
        ll cnt = 1, res = 1;

        while(true) {
            if(cnt % n == 0) {
                cout << res << '\n';
                break;
            }
            else {
                cnt = (cnt * 10 + 1) % n;
                res++;
            }
        }
    }

}