#include <stdio.h>
#define MAX(a, b) (a > b ? a : b)
#define MIN(a, b) (a > b ? b : a)

int main() {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    
    int max = MAX(a, MAX(b, c));
    int min = MIN(a, MIN(b, c));
    
    int mid = a + b + c - max - min;
    
    printf("%d", mid);
    
}