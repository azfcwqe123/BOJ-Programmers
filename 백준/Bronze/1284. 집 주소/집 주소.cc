#include <bits/stdc++.h>
using namespace std;

int main() {
    
    int n;
    
    while(true) {
        cin >> n;
        
        if(n == 0) return 0;
        
        int sum = 1;
        
        while(n > 0) {
            int tmp = n % 10;
            
            sum += (tmp == 0 ? 4 : (tmp == 1 ? 2 : 3)) + 1;
            
            n /= 10;
        }
        
        cout << sum << '\n';
    }
    
}