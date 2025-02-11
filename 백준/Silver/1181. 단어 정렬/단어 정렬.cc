#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int compare(string a, string b) {
    if(a.length() == b.length()) return a < b;
    else return a.length() < b.length();
}

int main() {
    string str[20001];
    
    int n;
    cin >> n;
    
    for(int i=0; i<n; i++) {
        cin >> str[i];
    }
    
    sort(str, str + n, compare);
    
    cout << str[0] << endl;
    for(int i=1; i<n; i++) {
        if(str[i] == str[i-1]) continue;
        else cout << str[i] << endl;
    }
    
}