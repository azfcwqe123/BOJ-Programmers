#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    
    int N, K, maxSum = -10000001, tmp = 0;
    cin >> N >> K;
    
    vector<int> v(N+1);
    
    for(int i=1; i<=N; i++) {
        cin >> v[i];
    }
    
    
    for(int i=1; i<=N; i++) {
        tmp += v[i];
        
        if(i == K) {
            maxSum = max(maxSum, tmp);
        } 
        
        else if(i >= K) {
            tmp -= v[i - K];
            
            maxSum = max(maxSum, tmp);
        }
        
    }
    
    cout << maxSum << '\n';
    
}