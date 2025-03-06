#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    
    char str[257];
    char alphabet[5] = {'a', 'e', 'i', 'o', 'u'};
    
    while(fgets(str, sizeof(str), stdin) && str[0] != '#') {
        int len = strlen(str);
        if(str[len - 1] == '\n') str[len - 1] = '\0';
        
        int cnt = 0;
        
        for(int i=0; i<len; i++) {
            char ch = tolower(str[i]);
            
            for(int j=0; j<5; j++) {
                if(ch == alphabet[j]) cnt++;
            }
        }
        
        printf("%d\n", cnt);
    }
    
}