# [Silver II] 최소 힙 - 1927 

[문제 링크](https://www.acmicpc.net/problem/1927) 

### 성능 요약

메모리: 35276 KB, 시간: 328 ms

### 분류

자료 구조, 우선순위 큐

### 제출 일자

2025년 2월 11일 14:28:49

### 문제 설명

<p>널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.</p>

<ol>
	<li>배열에 자연수 x를 넣는다.</li>
	<li>배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.</li>
</ol>

<p>프로그램은 처음에 비어있는 배열에서 시작하게 된다.</p>

### 입력 

 <p>첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. x는 2<sup>31</sup>보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.</p>

### 출력 

 <p>입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.</p>

---

최소힙 구현

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        MinHeap heap = new MinHeap();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            if(k == 0) sb.append(heap.delete()).append('\n');
            else heap.insert(k);
        }
        
        System.out.print(sb);
    }
    
}

class MinHeap {
    
    private ArrayList<Integer> heap;
    
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0); // 0번 인덱스는 사용하지 않는다.
    }
    
    public void insert(int val) {
        heap.add(val);
        
        int cur_idx = heap.size() - 1; // 현재 인덱스
        int par_idx = cur_idx / 2; // 부모 인덱스
        
        // 자식 노드값이 부모 노드값보다 작으면 교체
        while(cur_idx > 1 && (val < heap.get(par_idx))) {
            int tmp = heap.get(par_idx);
            heap.set(par_idx, val);
            heap.set(cur_idx, tmp);
            
            cur_idx = par_idx; // 자식 노드가 부모 노드의 위치로
            par_idx = cur_idx / 2; // 새로운 부모를 탐색하기 위해 갱신
        }
    }
    
    public int delete() {
        if(heap.size() == 1) return 0; // 노드가 없으면 0 반환
        
        int root = heap.get(1); // 루트 노드에서 값을 꺼내고
        heap.set(1, heap.get(heap.size() - 1)); // 최하단 노드의 값을 루트 노드 자리에 삽입
        heap.remove(heap.size() - 1);
        
        int cur_idx = 1; // 루트 노드부터 재정렬 해야함
        while(cur_idx * 2 < heap.size()) { // 자식 노드가 있을때
            
            int lt_idx = cur_idx * 2; // 왼쪽 자식 노드
            int rt_idx = cur_idx * 2 + 1; // 오른쪽 자식 노드
            
            int min_idx = lt_idx;
            int min_val = heap.get(lt_idx);
            
            // 오른쪽 노드가 왼쪽 노드보다 크면 스왑
            if(rt_idx < heap.size() && min_val > heap.get(rt_idx)) {
                min_val = heap.get(rt_idx);
                min_idx = rt_idx;
            }
            
            if(min_val > heap.get(cur_idx)) break; // 현재 노드가 자식보다 작으면 갱신X
            
            // 현재 노드가 자식보다 크면 갱신
            int tmp = heap.get(cur_idx);
            heap.set(cur_idx, heap.get(min_idx));
            heap.set(min_idx, tmp);
            cur_idx = min_idx;
        }
        
        return root; // 제거했던 것을 리턴
    }
}


```

---

![image](https://github.com/user-attachments/assets/0b9ec45a-5e27-469f-b231-63af709bffdf)
