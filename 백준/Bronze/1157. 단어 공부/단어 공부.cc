#include <iostream>
#include <string.h>
#include <cctype>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string str;
    cin >> str;
    
    int arr[26] = {0};
    
    for(int i=0; i<str.length(); i++) {
        char k = toupper(str[i]);
        arr[k - 'A']++;
    }
    
    int cnt = 0;
    char ch;
    
    for(int i=0; i<26; i++) {
        if(cnt < arr[i]) {
            cnt = arr[i];
            ch = (char) (i + 65);
        }
        else if(cnt == arr[i]) {
            ch = '?';
        }
    }
    
   cout << ch;
    
}