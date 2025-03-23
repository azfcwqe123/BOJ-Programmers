#include <stdio.h>
#include <string.h>

int main() {
    int n, p;
    int max, price;
    char pick[20], name[20];
    
    scanf("%d", &n);
    
    while(n--) {
        scanf("%d", &p);
        max = -1;
        
        while(p--) {
            scanf("%d %s", &price, name);
            
            if(max < price) {
                max = price;
                strcpy(pick, name);
            }
        }
        
        printf("%s\n", pick);
    }
}