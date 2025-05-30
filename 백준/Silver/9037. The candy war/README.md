# [Silver V] The candy war - 9037 

[문제 링크](https://www.acmicpc.net/problem/9037) 

### 성능 요약

메모리: 1116 KB, 시간: 0 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2025년 4월 12일 01:08:16

### 문제 설명

<p>알고리즘 유치원 선생님인 영희는 간식시간이 되자 아이들에게 사탕을 나누어 주려고 하였다. 하지만 욕심 많고 제멋대로인 유치원 아이들은 차례대로 받으라는 선생님의 말을 무시한 채 마구잡이로 사탕을 집어 갔고 많은 사탕을 집어 간 아이가 있는가 하면 사탕을 거의 차지하지 못하고 우는 아이도 있었다. </p>

<p>말로 타일러도 아이들이 말을 듣지 않자 영희는 한 가지 놀이를 제안했다. 일단 모든 아이들이 원으로 둘러 앉는다. 그리고 모든 아이들은 동시에 자기가 가지고 있는 사탕의 절반을 오른쪽 아이에게 준다. 만약 이 결과 홀수개의 사탕을 가지게 된 아이가 있을 경우 선생님이 한 개를 보충해 짝수로 만들어 주기로 했다. 흥미로워 보이는 이 놀이에 아이들은 참여 했고 이 과정을 몇 번 거치자 자연스럽게 모든 아이들이 같은 수의 사탕을 가지게 되어 소란은 종료되었다.</p>

<p>자기가 가진 사탕의 반을 옆에 오른쪽에 앉은 아이에게 주는 과정과 선생님이 사탕을 보충해 주는 과정을 묶어서 1 순환이라고 할 때 몇 번의 순환을 거치면 모든 아이들이 같은 수의 사탕을 가지게 되는지 계산 해보자. 단, 처음부터 홀수개의 사탕을 가지고 있으면 선생님이 짝수로 보충을 먼저 해주며 이 경우 순환수에 들어가지 않는다. 선생님은 충분한 수의 사탕을 갖고 있다고 가정하자.</p>

### 입력 

 <p>입력은 표준입력(standard input)을 통해 받아들인다. 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 각각의 테스트 케이스의 첫 줄에는 아이의 인원 N (1 ≤ N ≤ 10)이 주어지고 그 다음 줄에는 각 아이들이 초기에 가지고 있는 사탕의 개수 C<sub>i</sub> ( 1 ≤ i ≤ N, 1 ≤ C<sub>i</sub> ≤ 30)가 주어진다. 분배 시 C<sub>1</sub>의 오른쪽에는 C<sub>2</sub>가, C<sub>2</sub>의 오른쪽에는 C<sub>3</sub>가…… 같은 식으로 앉게 되며 C<sub>N</sub>의 오른쪽에는 C<sub>1</sub>이 앉게 된다.</p>

### 출력 

 <p>출력은 표준출력(standard output)을 통하여 출력한다. 각 테스트 케이스에 대하여 모든 아이가 같은 개수의 사탕을 가질 때까지 몇 순환이 걸리는지 출력하시오.</p>

---

구현

```C
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void isOdd(int arr[], int size) { // 홀수면 하나씩 더 준다.
    int i;
    for (i = 0; i < size; i++) {
		if (arr[i] % 2 != 0) arr[i]++;
	}
}

int isSuccess(int arr[], int size) { // 모든 인원의 사탕 수가 같으면 1을 리턴, 아니면 0을 리턴
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
		
		arr = (int*)malloc(n * sizeof(int)); // 현재 인원이 가지고 있는 사탕의 수
		tmp = (int*)malloc(n * sizeof(int)); // 절반으로 나눈 사탕을 담을 바구니
		
		for (i = 0; i < n; i++) scanf("%d", &arr[i]);
		
		cnt = 0; // 몇번 사이클이 돌았는지
		
		isOdd(arr, n);
		
		while (!isSuccess(arr, n)) { // 모든 인원의 사탕 수가 같을때까지
			
			for (i = 0; i < n; i++) {
				tmp[i] = arr[i] / 2; // 현재 인원이 가지고 있는 사탕의 절반을 바구니에 담는다.
				arr[i] /= 2; // 현재 인원의 사탕 수를 절반 뺀다.
			}

                        // n이 4라고 가정
			for (i = 0; i < n; i++) { 
				if (i == n - 1) arr[0] += tmp[i]; // 0번 -> 1번, 1번 -> 2번, 2번 -> 3번, 3번 -> 0번(이때를 위해 n-1을 따로 설정)
				else arr[i + 1] += tmp[i]; // 나머지는 옆으로 전달
			}
			
			isOdd(arr, n);
			
              cnt++;
		}

		printf("%d\n", cnt);

		free(arr);
		free(tmp);
	}

}
```
천천히 풀면은 쉽게 풀 수 있는 문제

---

![image](https://github.com/user-attachments/assets/a6e7ca8a-9af3-4bc3-bc61-e35deb885de8)

