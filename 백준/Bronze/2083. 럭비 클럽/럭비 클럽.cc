#include <bits/stdc++.h>
using namespace std;

int main() {
    string name;
    int age, weight;
    
    while(cin >> name >> age >> weight) {
        
        if(name == "#") break;
        
        cout << name << (age > 17 || weight >= 80 ? " Senior" : " Junior") << '\n';
    }
}