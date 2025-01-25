# [Gold V] 강의실 배정 - 11000 

[문제 링크](https://www.acmicpc.net/problem/11000) 

### 성능 요약

메모리: 69912 KB, 시간: 596 ms

### 분류

자료 구조, 그리디 알고리즘, 우선순위 큐, 정렬

### 제출 일자

2025년 1월 23일 16:11:31

### 문제 설명

<p>수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다. </p>

<p>김종혜 선생님한테는 S<sub>i</sub>에 시작해서 T<sub>i</sub>에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. </p>

<p>참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, T<sub>i</sub> ≤ S<sub>j</sub> 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)</p>

<p>수강신청 대충한 게 찔리면, 선생님을 도와드리자!</p>

### 입력 

 <p>첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)</p>

<p>이후 N개의 줄에 S<sub>i</sub>, T<sub>i</sub>가 주어진다. (0 ≤ S<sub>i</sub> < T<sub>i</sub> ≤ 10<sup>9</sup>)</p>

### 출력 

 <p>강의실의 개수를 출력하라.</p>

---

그리디 알고리즘 + 우선순위큐
```java
import java.util.*;
import java.io.*;

class Time implements Comparable<Time>{
    int st;
    int ed;
    
    Time(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }
    
    public int compareTo(Time ob) {
        if(this.st == ob.st) return this.ed - ob.ed;
        else return this.st - ob.st;
    }
}

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Time> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.add(new Time(a, b));
        }
        
        Collections.sort(list);
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.add(list.get(0).ed);
        
        for(int i=1; i<n; i++) {
            
            if(pQ.peek() <= list.get(i).st) {
                pQ.poll();
            }
            
            pQ.add(list.get(i).ed);
        }
        
        System.out.print(pQ.size());
        
    }
    
}


```

---

참고: https://sookr5416.tistory.com/276

---

![image](https://github.com/user-attachments/assets/6ce076bd-ba20-43c5-a363-73b95f8b4471)
