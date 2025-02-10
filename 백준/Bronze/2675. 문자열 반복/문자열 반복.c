#include <stdio.h>
#include <string.h>

int main() {
    
    int T;
    scanf("%d", &T);
    
    while(T--) {
        int r;
        char str[21];
        
        scanf("%d %s", &r, str);
        
        for(int i=0; i<strlen(str); i++) {
            for(int j=0; j<r; j++) {
                printf("%c", str[i]);
            }
        }
        
        printf("\n");
    }
    
    return 0;
    
}