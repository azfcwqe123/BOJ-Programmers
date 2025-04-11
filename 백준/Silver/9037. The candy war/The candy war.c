#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void isOdd(int arr[], int size) {
    int i;
    for (i = 0; i < size; i++) {
		if (arr[i] % 2 != 0) arr[i]++;
	}
}

int isSuccess(int arr[], int size) {
    int i;
    for (i = 0; i < size - 1; i++) {
		if (arr[i] != arr[i + 1]) return 0;
	}
	return 1;
}

void main() {
	int T, n, i, cnt = 0;
	int *arr, *tmp;
	
	scanf("%d", &T);

	while (T--) {
		scanf("%d", &n);
		
		arr = (int*)malloc(n * sizeof(int));
		tmp = (int*)malloc(n * sizeof(int));
		
		for (i = 0; i < n; i++) scanf("%d", &arr[i]);
		
		cnt = 0;
		
		while (1) {
			
			isOdd(arr, n);
			
			if(isSuccess(arr, n)) break;
			
			for (i = 0; i < n; i++) {
				tmp[i] = arr[i] / 2;
				arr[i] /= 2;
			}

			for (i = 0; i < n; i++) {
				if (i == n - 1) arr[0] += tmp[i];
				else arr[i + 1] += tmp[i];
			}
			
			isOdd(arr, n);
			
            cnt++;
			if(isSuccess(arr, n)) break;
		}

		printf("%d\n", cnt);

		free(arr);
		free(tmp);
	}

}