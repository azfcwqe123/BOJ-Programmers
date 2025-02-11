#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void* arg1, const void* arg2) {
    char a = *(char*) arg1;
    char b = *(char*) arg2;
    
    if (a < b) return 1;
    else if (a > b) return -1;
    else return 0;
}

int main() {
    char arr[10];
    scanf("%s", arr);
    
    qsort(arr, strlen(arr), sizeof(char), compare);
    
    printf("%s\n", arr);
    
    return 0;
}
