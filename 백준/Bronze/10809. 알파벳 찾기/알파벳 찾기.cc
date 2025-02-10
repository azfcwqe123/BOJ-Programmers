#include <iostream>
#include <string.h>

using namespace std;

int main() {
    
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string str;
    cin >> str;
    
    int arr[26];
    memset(arr, -1, sizeof(arr));
    
    for(int i=0; i<str.length(); i++) {
        if(arr[str[i] - 'a'] == -1) arr[str[i] - 'a'] = i;
    }
    
    for(int i=0; i<26; i++) {
        cout << arr[i] << " ";
    }
    
}