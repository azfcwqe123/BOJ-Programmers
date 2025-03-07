#include <stdio.h>
#include <limits.h>

int main() {
    
    int n, max = INT_MIN, min = INT_MAX;
    
    scanf("%d", &n);
    
    int tmp;
    for(int i=0; i<n; i++) {
        scanf("%d", &tmp);
        
        if(tmp > max) max = tmp;
        if(tmp < min) min = tmp;
    }
    
    printf("%d %d", min, max);
}