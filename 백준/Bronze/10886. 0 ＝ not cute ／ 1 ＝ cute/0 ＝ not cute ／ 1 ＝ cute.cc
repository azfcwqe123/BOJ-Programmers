#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k, cnt = 0;
    cin >> n;
    
    while(n--) {
       cin >> k;
       
       k == 1 ? cnt++ : cnt--;
    }
    
    cout << (cnt <= 0 ? "Junhee is not cute!" : "Junhee is cute!");
}