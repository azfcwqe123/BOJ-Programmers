#include <stdio.h>
#include <string.h>
#define max(a, b) (a > b ? a : b)

int main() {
    int n, p;
    
    scanf("%d", &n);
    
    while(n--) {
        scanf("%d", &p);
        int maxPrice, max = -1;
        char pick[20];
        
        while(p--) {
            int price;
            char name[20];
            
            scanf("%d %s", &price, name);
            
            if(max < price) {
                max = price;
                strcpy(pick, name);
            }
        }
        
        printf("%s\n", pick);
    }
}