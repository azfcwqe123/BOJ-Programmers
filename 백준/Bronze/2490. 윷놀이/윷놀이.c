#include <stdio.h>

void check(int cnt);

int main() {
    
    int k, cnt;
    
    for(int i=0; i<3; i++) {
        cnt = 0;
        for(int j=0; j<4; j++) {
            scanf("%d", &k);
            if(k == 1) cnt++;
        }
        check(cnt);

    }
    
}

void check(int cnt) {
    if(cnt == 0) printf("D\n");
    else if(cnt == 1) printf("C\n");
    else if(cnt == 2) printf("B\n");
    else if(cnt == 3) printf("A\n");
    else if(cnt == 4) printf("E\n");
}
