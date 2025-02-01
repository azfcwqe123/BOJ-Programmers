# [Silver V] 다리 놓기 - 1010 

[문제 링크](https://www.acmicpc.net/problem/1010) 

### 성능 요약

메모리: 14160 KB, 시간: 108 ms

### 분류

조합론, 다이나믹 프로그래밍, 수학

### 제출 일자

2025년 2월 1일 15:10:00

### 문제 설명

<p>재원이는 한 도시의 시장이 되었다. 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다. 하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다. 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)</p>

<p>재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다. 다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/201003/pic1.JPG" style="height:353px; width:329px"></p>

### 입력 

 <p>입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.</p>

### 출력 

 <p>각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.</p>

---

메모이제이션 + Top-Down + dp + 조합론

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[30][30]; // 메모이제이션
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            sb.append(combi(n, r)).append("\n");
        }
        
        System.out.print(sb);
        
    }
    
    static int combi(int n, int r) {
        
        if(dp[n][r] > 0) return dp[n][r];
        
        if(n == r || r == 0) return dp[n][r] = 1;
        
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
    
}


```

---

Bottom-Up + dp + 조합론

```java
import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[30][30];
    
    public static void main(String[] args) throws IOException {
        
        for(int i=0; i<30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        
        for(int i=2; i<30; i++) {
            for(int j=1; j<30; j++) {
                
                if(j-1 > i-1 || j > i-1) continue; // 조합 성질에 위배되는것은 PASS
                
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            sb.append(dp[n][r]).append("\n");
        }
        
        System.out.print(sb);
        
    }
}


```

---

참고: https://st-lab.tistory.com/194

아주 좋은 문제인듯

![image](https://github.com/user-attachments/assets/6298f157-de05-4101-ac26-e4ec2763fbe9)
