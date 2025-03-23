#include <stdio.h>

int main() {
    int T, n, C, sum;
    double G, score;
    
    scanf("%d", &T);
    
    while(T--) {
        scanf("%d", &n);
        sum = score = 0;
        
        for(int i=0; i<n; i++) {
            scanf("%d %lf", &C, &G);
            sum += C;
            score += G * C;
        }
        
        printf("%d %.1lf\n", sum, score / sum);
    }
    
}
