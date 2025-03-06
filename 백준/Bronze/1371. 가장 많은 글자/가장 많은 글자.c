#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <limits.h>

int main() {
    
    int alpha[26] = {0};
    char str[51];
    
    while(fgets(str, sizeof(str), stdin)) {
        int len = strlen(str);
        
        for(int i=0; i<len; i++) {
            if(str[i] != ' ') alpha[str[i] - 'a']++;
        }
    }
    
    int max = INT_MIN;
    
    for(int i=0; i<26; i++) {
        if(max < alpha[i]) max = alpha[i];
    }
    
    for(int i=0; i<26; i++) {
        if(max == alpha[i]) printf("%c", (char) (i + 97));
    }
    
}