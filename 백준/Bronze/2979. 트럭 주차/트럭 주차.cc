#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    int t1, t2, t3, sum = 0, a, b;
    cin >> t1 >> t2 >> t3;
    
    int cur[101] = {0};
    
    for(int i=0; i<3; i++) {
        cin >> a >> b;
        
        for(int j=a; j<b; j++) {
            cur[j]++;
        }
    }
    
    for(int i=1; i<=100; i++) {
        
        if(cur[i] == 1) sum += t1;
        else if(cur[i] == 2) sum += t2 * 2;
        else if(cur[i] == 3) sum += t3 * 3;
    }
    
    cout << sum << '\n';
}