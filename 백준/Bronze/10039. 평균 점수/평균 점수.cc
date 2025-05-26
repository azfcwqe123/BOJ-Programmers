#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n, sum = 0;
    
    for(int i=0; i<5; i++) {
        cin >> n;
        if(n < 40) sum += 40;
        else sum += n;
    }
    
    cout << sum / 5<< '\n';
}