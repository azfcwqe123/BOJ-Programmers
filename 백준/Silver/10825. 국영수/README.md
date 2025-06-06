# [Silver IV] 국영수 - 10825 

[문제 링크](https://www.acmicpc.net/problem/10825) 

### 성능 요약

메모리: 66116 KB, 시간: 700 ms

### 분류

정렬

### 제출 일자

2025년 3월 21일 23:30:55

### 문제 설명

<p>도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.</p>

<ol>
	<li>국어 점수가 감소하는 순서로</li>
	<li>국어 점수가 같으면 영어 점수가 증가하는 순서로</li>
	<li>국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로</li>
	<li>모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)</li>
</ol>

### 입력 

 <p>첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다. 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.</p>

### 출력 

 <p>문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.</p>

---

정렬

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;
        
        Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        
        @Override
        public int compareTo(Student ob) {
            if(this.kor == ob.kor) {
                if(this.eng == ob.eng) {
                    if(this.math == ob.math) {
                        return this.name.compareTo(ob.name);
                    }
                    return ob.math - this.math;
                }
                return this.eng - ob.eng;
            }
            return ob.kor - this.kor;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        ArrayList<Student> list = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            
            list.add(new Student(name, kor, eng, math));
        }
        
        Collections.sort(list);
        
        for(Student x : list) {
            sb.append(x.name + "\n");
        }
        
        System.out.print(sb);
    }
    
}


```

---

![image](https://github.com/user-attachments/assets/72344e2d-d1e3-4191-ac5b-c15b5ea842a9)

