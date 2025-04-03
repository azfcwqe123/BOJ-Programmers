#include <stdio.h>

int main() {
    
    int n;
    scanf("%d", &n);
    
    int m, sum = 0;
    
    for(int i=0; i<n; i++) {
        scanf("%d", &m);
        sum += m;
    }
    
    sum = sum - n + 1;
    
    printf("%d", sum);
    
}

