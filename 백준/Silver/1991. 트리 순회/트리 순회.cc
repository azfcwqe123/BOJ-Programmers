#include <bits/stdc++.h>
using namespace std;

pair<char, char> node[26];

void VLR(char root) {
    
    if(root == '.') return;
    
    cout << root;
    VLR(node[root - 'A'].first);
    VLR(node[root - 'A'].second);
}

void LVR(char root) {
    
    if(root == '.') return;
    
    LVR(node[root - 'A'].first);
    cout << root;
    LVR(node[root - 'A'].second);
}

void LRV(char root) {
    
    if(root == '.') return;
    
    LRV(node[root - 'A'].first);
    LRV(node[root - 'A'].second);
    cout << root;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n; cin >> n;

    char parent, lt, rt;
    
    for(int i=0; i<n; i++ ) {
        cin >> parent >> lt >> rt;
        
        node[parent - 'A'].first = lt;
        node[parent - 'A'].second = rt;
    }
    
    VLR('A'); 
    cout << '\n';
    LVR('A');
    cout << '\n';
    LRV('A');
}