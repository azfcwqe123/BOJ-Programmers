#include <stdio.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

int main() {
    
    char str[1000001];
    scanf("%s", str);
    
    int arr[26];
    int len = strlen(str);
    
    for(int i=0; i<len; i++) {
        char k = toupper(str[i]);
        arr[k - 'A']++;
    }
    
    int ans = 0;
    char ch;
    
    for(int i=0; i<26; i++) {
        if(ans < arr[i]) {
            ans = arr[i];
            ch = (char) (i + 65);
        }
        else if(ans == arr[i]) ch = '?';
    }
    
    printf("%c", ch);
    
}