#include <iostream>

using namespace std;

int main() {
    
    int n;
    string str;
    
    cin >> n >> str;
    
    int sum = 0;
    
    for(int i=0; i<n; i++) {
        sum += str[i] - '0';
    }
    
    cout << sum;
    
    return 0;
}