#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    for(int i=0; i<3; i++) {
        int n, flow = 0;
        cin >> n;
        
        long long tmp, sum = 0;
        while(n--) {
            cin >> tmp;
            
            long long prevSum = sum;
            
            sum += tmp;
            
            if(tmp > 0 && prevSum > 0 && sum < 0) flow++;
            else if(tmp < 0 && prevSum < 0 && sum > 0) flow--;
        }
        
        if(flow == 0) cout << (sum == 0 ? '0' : (sum > 0 ? '+' : '-')) << '\n';
        else cout << (flow > 0 ? '+' : '-') << '\n';
    }
}