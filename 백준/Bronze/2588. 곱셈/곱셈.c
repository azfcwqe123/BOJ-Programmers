#include <stdio.h>

int main() {
    int num1, num2;
    scanf("%d %d", &num1, &num2);
    
    int ans = num1 * num2;
    
    while(num2 > 0) {
        printf("%d\n", num1 * (num2 % 10));
        num2 /= 10;
    }
    
    printf("%d", ans);
}