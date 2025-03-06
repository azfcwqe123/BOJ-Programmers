#include <stdio.h>
#include <string.h>

int main() {
    
    char str[100000];
    
    while(scanf("%s", str) && str[0] != '0') {
        
        int lt = 0, rt = strlen(str) - 1;
        int check = 1;
        
        while(lt < rt) {
            if(str[lt] != str[rt]) {
                check = 0;
                break;
            }
            lt++;
            rt--;
        }
        
        if(check == 1) printf("yes\n");
        else printf("no\n");
    }
    
}