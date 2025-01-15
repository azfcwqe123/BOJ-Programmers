# [Gold V] 상범 빌딩 - 6593 

[문제 링크](https://www.acmicpc.net/problem/6593) 

### 성능 요약

메모리: 18468 KB, 시간: 188 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 1월 15일 21:45:39

### 문제 설명

<p>당신은 상범 빌딩에 갇히고 말았다. 여기서 탈출하는 가장 빠른 길은 무엇일까? 상범 빌딩은 각 변의 길이가 1인 정육면체(단위 정육면체)로 이루어져있다. 각 정육면체는 금으로 이루어져 있어 지나갈 수 없거나, 비어있어서 지나갈 수 있게 되어있다. 당신은 각 칸에서 인접한 6개의 칸(동,서,남,북,상,하)으로 1분의 시간을 들여 이동할 수 있다. 즉, 대각선으로 이동하는 것은 불가능하다. 그리고 상범 빌딩의 바깥면도 모두 금으로 막혀있어 출구를 통해서만 탈출할 수 있다.</p>

<p>당신은 상범 빌딩을 탈출할 수 있을까? 만약 그렇다면 얼마나 걸릴까?</p>

### 입력 

 <p>입력은 여러 개의 테스트 케이스로 이루어지며, 각 테스트 케이스는 세 개의 정수 L, R, C로 시작한다. L(1 ≤ L ≤ 30)은 상범 빌딩의 층 수이다. R(1 ≤ R ≤ 30)과 C(1 ≤ C ≤ 30)는 상범 빌딩의 한 층의 행과 열의 개수를 나타낸다.</p>

<p>그 다음 각 줄이 C개의 문자로 이루어진 R개의 행이 L번 주어진다. 각 문자는 상범 빌딩의 한 칸을 나타낸다. 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고, 비어있는 칸은 '.'으로 표현된다. 당신의 시작 지점은 'S'로 표현되고, 탈출할 수 있는 출구는 'E'로 표현된다. 각 층 사이에는 빈 줄이 있으며, 입력의 끝은 L, R, C가 모두 0으로 표현된다. 시작 지점과 출구는 항상 하나만 있다.</p>

### 출력 

 <p>각 빌딩에 대해 한 줄씩 답을 출력한다. 만약 당신이 탈출할 수 있다면 다음과 같이 출력한다.</p>

<blockquote>Escaped in x minute(s).</blockquote>

<p>여기서 x는 상범 빌딩을 탈출하는 데에 필요한 최단 시간이다.</p>

<p>만일 탈출이 불가능하다면, 다음과 같이 출력한다.</p>

<blockquote>Trapped!</blockquote>

---

BFS, 3차원 배열

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Person {
        int x;
        int y;
        int z;
        
        Person(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static char[][][] apt;
	private static int[] dz = {-1, 0, 0, 1, 0, 0};
	private static int[] dy = {0, -1, 1, 0, 0, 0};
	private static int[] dx = {0, 0, 0, 0, -1, 1};
    
    public static int L, R, C;
    public static Queue<Person> Q;
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            Q = new LinkedList<>();
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if(L == 0 && R == 0 && C == 0) return;
            
            apt = new char[L][R][C];
            
            for(int i=0; i<L; i++) {
               for(int j=0; j<R; j++) {
                    String str = br.readLine();
                    for(int k=0; k<C; k++) {
                        apt[i][j][k] = str.charAt(k);
                        
                        if(apt[i][j][k] == 'S') Q.offer(new Person(i, j, k));
                    }
                }   
                br.readLine();
            }
            
            int ans = BFS();
            
            if(ans == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + ans + " minute(s).");
        }
        
    }
    
    public static int BFS() {
        
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Person cur = Q.poll();
                
                for(int d=0; d<6; d++) {
                    
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    int nz = cur.z + dz[d];
                    
                    if(!rangeCheck(nx, ny, nz)) continue;
                    
                    if(apt[nx][ny][nz] == 'E') return cnt + 1;
                    
                    if(apt[nx][ny][nz] == '.') {
                        apt[nx][ny][nz] = 'S'; // 방문 처리
                        Q.offer(new Person(nx, ny, nz));
                    }
                }
            }
            
            cnt++;
        }
        
        return -1;
        
    }
    
    public static boolean rangeCheck(int nx, int ny, int nz) {
        return nx >= 0 && ny >= 0 && nz >= 0 && nx < L && ny < R && nz < C;
    }
    
}


```

---

분명 맞게 푼거 같은데 왜 자꾸 안풀리나 했는데 "minute(s)"을 "minutes(s)"으로 오타를 쓰는 바람에 30분동안 헛고생했다.

![image](https://github.com/user-attachments/assets/9efd08cc-8e13-4cb2-aff1-f228abc2181a)
