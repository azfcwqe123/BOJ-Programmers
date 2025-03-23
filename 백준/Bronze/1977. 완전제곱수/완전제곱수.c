#include <stdio.h>
#define MAX 10001
#define getMin(a, b) (a > b ? b : a)

int main() {
    int m, n;
    scanf("%d %d", &m, &n);
    
    int sum = 0, min = MAX;
    
    for(int i=m; i<=n; i++) {
        
        for(int j=1; j*j<=i; j++) {
            if(j*j == i) {
                sum += j*j;
                min = getMin(min, j*j);
            }
        }
    }
    
    if(sum == 0) printf("-1");
    else printf("%d\n%d", sum, min);
}