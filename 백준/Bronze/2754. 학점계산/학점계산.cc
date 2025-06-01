#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    string grade;
    cin >> grade;
    
    double score;
    
    switch(grade[0]) {
        case 'A' : score = 4.0; break;
        case 'B' : score = 3.0; break;
        case 'C' : score = 2.0; break;
        case 'D' : score = 1.0; break;
    }
    
    switch(grade[1]) {
        case '+' : score += 0.3; break;
        case '-' : score -= 0.3; break;
    }
    
    
    cout << fixed << setprecision(1) << score << '\n';
    
}