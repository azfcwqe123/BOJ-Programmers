#include <stdio.h>
#include <string.h>

int main() {
    
    char str[101];
    int ch[26];
    memset(ch, -1, sizeof(ch)); 
    
    scanf("%s", str);
    
    for(int i=0; i<strlen(str); i++) {
        if(ch[str[i] - 'a'] == -1) ch[str[i] - 'a'] = i;
    }
    
    for(int i=0; i<26; i++) {
        printf("%d ", ch[i]);
    }
}