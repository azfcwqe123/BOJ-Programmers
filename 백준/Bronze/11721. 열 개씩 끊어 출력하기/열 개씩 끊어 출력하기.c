#include <stdio.h>
#include <string.h>

int main() {
    
    char arr[100];
    scanf("%s", arr);
    
    int len = strlen(arr);
    
    for(int i=0; i<len; i++) {
        
        if(i % 10 == 0 && i != 0) printf("\n");
        
        printf("%c", arr[i]);
    }
    
}