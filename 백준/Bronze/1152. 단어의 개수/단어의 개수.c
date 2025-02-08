#include <stdio.h>

int main() {
    
    char str[1000001];
    int ans = 1;
    
    scanf("%[^\n]", str);
    
    int len = strlen(str);
    
    for(int i=0; i<len; i++) {
        if(str[i] == ' ') ans++;
    }
    
    if(str[0] == ' ') ans--;
    if(str[len - 1] == ' ') ans--;
    
    printf("%d", ans);
}