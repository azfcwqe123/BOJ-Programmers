#include <stdio.h>
#include <string.h>

int main() {
    int a[3], b[3], t[3];
    
    scanf("%d:%d:%d", &a[0], &a[1], &a[2]); // 현재시간
    scanf("%d:%d:%d", &b[0], &b[1], &b[2]); // 남은시간
    
    int start = a[0] * 3600 + a[1] * 60 + a[2];
    int end = b[0] * 3600 + b[1] * 60 + b[2];
    
    if(start > end) end += 3600 * 24;
    
    int tmp = end - start;
    
    t[0] = tmp / 3600;
    tmp %= 3600;
    
    t[1] = tmp / 60;
    tmp %= 60;
    
    t[2] = tmp;
    
    printf("%02d:%02d:%02d", t[0], t[1], t[2]);
    
}
